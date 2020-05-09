package datastructure;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        //写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出系统");
            System.out.println("find:查找雇员");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp =new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                case "find":
                    System.out.println("请输入要查找的雇员");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                default:
                    break;
            }
        }
    }
}
//创建HashTab管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    //构造器
    public HashTab(int size){
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //留一个坑，这时不要分别初始化每个链表
        for (int i=0;i<size;i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工，得到员工应该添加到那条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    public void list(){
        for (int i=0;i<size;i++){
            empLinkedListArray[i].list(i);
        }
    }
    public void findEmpById(int id){
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp!=null){
            System.out.printf("在第%d中找到雇员id=%d \n",(empLinkedListNO+1),id);
        }else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    public int hashFun(int id){
        return id % size;
    }
}



class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp (int id,String name){
        super();
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{
    private Emp head;
    //添加雇员到链表
    //1.假设添加雇员时，id自增长，从小到大
    //因此直接将该雇员直接加入到本科链的最后即可
    public void add(Emp emp){
        if (head==null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    public void list(int no){
        if (head==null){
            System.out.println("第"+(no+1)+" 链表为空");
            return;
        }
        System.out.println("第"+(no+1)+" 链表的信息为");
        Emp curEmp = head;
        while (true){
            System.out.printf("=>id=%d name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;//后移,遍历
        }
        System.out.println();
    }
//如果查找到就返回Emp，如果没查找到，就返回null
    public Emp findEmpById(int id){
        if (head==null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id==id){
                break;
            }
            //退出
            if (curEmp.next==null){
                //说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

}