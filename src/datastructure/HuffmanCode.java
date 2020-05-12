package datastructure;

import netscape.security.UserTarget;

import java.net.BindException;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentByte = content.getBytes();
        byte[] huffmanCodesBytes = huffmanZip(contentByte);
        System.out.println("压缩后的结果"+Arrays.toString(huffmanCodesBytes));
        //测试一把byteToBitString方法
        //System.out.println(byteToBitString((byte)1));
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);

        System.out.println("原来的字符串=" + new String(sourceBytes));
        //System.out.println(Arrays.toString(contentByte));
        //System.out.println(contentByte.length);//40

//        List<Node> nodes = getNodes(contentByte);//109行
//        System.out.println("nodes="+nodes);
//
//        //测试一把,创建二叉树
//        System.out.println("哈夫曼树");
//        Node huffmanTreeRoot = createHuffmanTree(nodes);
//        System.out.println("前序遍历");
//        preOrder(huffmanTreeRoot);
//
//        //测试生成的哈夫曼编码
//
//        //getCodes(huffmanTreeRoot,"",stringBuilder);
//        Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);//Byte 与 字符串 的map映射
//        //打印map
//        System.out.println("生成的哈夫曼编码表"+huffmanCodes);
//        byte[] huffmanCodeBytes = zip(contentByte,huffmanCodes);
//        //返回byte[] 类型
//        System.out.println("huffmanCodeBytes="+Arrays.toString(huffmanCodeBytes));
    }

    //使用一个方法，将前面的方法封装起来，便于我们的调用

    //* @bytes 原始字符串对应的字节数组
    //@return 是经过压缩后的数组



    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //创建赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //生成对应的赫夫曼编码
        Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);
        return huffmanCodeBytes;
    }
    //编写一个方法，完成对压缩数据的解码
    /**
     *
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes) {

        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for(int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte>  map = new HashMap<String,Byte>();
        for(Map.Entry<Byte, String> entry: huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引,扫描 stringBuilder
        for(int  i = 0; i < stringBuilder.length(); ) {
            int count = 1; // 小的计数器
            boolean flag = true;
            Byte b = null;

            while(flag) {
                //1010100010111...
                //递增的取出 key 1
                String key = stringBuilder.substring(i, i+count);//i 不动，让count移动，指定匹配到一个字符
                b = map.get(key);
                if(b == null) {//说明没有匹配到
                    count++;
                }else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;//i 直接移动到 count
        }
        //当for循环结束后，我们list中就存放了所有的字符  "i like like like java do you like a java"
        //把list 中的数据放入到byte[] 并返回
        byte b[] = new byte[list.size()];
        for(int i = 0;i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;

    }




    /**
     * 将一个byte 转成一个二进制的字符串, 如果看不懂，可以参考我讲的Java基础 二进制的原码，反码，补码
     * @param b 传入的 byte
     * @param flag 标志是否需要补高位如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @return 是该b 对应的二进制的字符串，（注意是按补码返回）
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存 b
        int temp = b; //将 b 转成 int
        //如果是正数我们还存在补高位
        if(flag) {
            temp |= 256; //按位与 256  1 0000 0000  | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码
        if(flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println("测试stringBuilder="+stringBuilder.toString());

        int len;
        if (stringBuilder.length()%8==0){
            len = stringBuilder.length()/8;
        }else {
            len = stringBuilder.length()/8+1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i=0;i<stringBuilder.length();i+=8){
            //每八位对应一个步长
            String strByte;
            if (i+8>stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i+8);
            }
            //strByte = stringBuilder.substring(i,i+8);
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }
    //生成赫夫曼树对应的赫夫曼编码
    //思路：
    //1.将赫夫曼编码表存放在Map<Byte,String>形式
    static Map<Byte,String> huffmanCodes = new HashMap<Byte, String>();
    //32->01 97->100 100->11000
    //2.在生成赫夫曼编码标时，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte,String> getCodes(Node root){
        if (root==null){
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }
    /*
    * 功能：将传入的node节点的所有叶子节点的哈夫曼编码得到，并放到HuffmanCodes 集合
    * node 传入节点
    * 路径：左节点是0，右节点1
    * stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //在前面的编码之后添加1或者0
        stringBuilder2.append(code);
        if (node!=null){
            //判断当前node是叶子节点还是非叶子节点
            if (node.data==null){
                //非叶子节点递归处理
                getCodes(node.left,"0",stringBuilder2);
                getCodes(node.right,"1",stringBuilder2);
            }else {
                //说明是叶子节点
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }
    //前序遍历
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("树是空的");
        }
    }

    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<Node>();
        //遍历bytes,用map【key,value】统计每一个byte的出现次数
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b:bytes){
            Integer count = counts.get(b);
            if (count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        //把每一个键值对转成一个Node 对象，并加入到nodes集合
        //遍历map
        for (Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    //通过List创建Huffman树
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            //取出第一棵最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二棵最小的二叉树
            Node rightNoe = nodes.get(1);
            //创建一颗心的二叉树，她的节点没有data，只有全职
            Node leftNode1 = leftNode;
            Node parent = new Node(null, leftNode.weight+rightNoe.weight);
            parent.left = leftNode;
            parent.right = rightNoe;
            nodes.remove(leftNode);
            nodes.remove(rightNoe);
            nodes.add(parent);
        }

        return nodes.get(0);
    }

}

class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大
        return this.weight-o.weight;
    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
}
