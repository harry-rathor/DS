import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import ds.LinkList;

// Main class should be named 'Solution'
class Solution {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World");


        QueueBuilder.Queue queue=new QueueBuilder("myqueue").initSize(10).threshold(.75f).setMessageTTL(7*24*60*60).create();

        for(int i = 1;i<10;i++){
            queue.put(new Message("msg:"+i));
        }

        String groupId="gp1";
        System.out.println(groupId);
        queue.subscribe(groupId);

        Message msg1=null;
        do {
            msg1=queue.poll(groupId);
            if(msg1!=null)
                System.out.println(msg1.data);
        }
        while(msg1!=null);

        String groupId1="gp2";

        queue.subscribe(groupId1);
        System.out.println(groupId1);
        Message msg2=null;
        do {
            msg2=queue.poll(groupId1);
            if(msg2!=null)
                System.out.println(msg2.data);
        }
        while(msg2!=null);

    }


}

class  Message{
    String data;
    long timeOfMsg=System.currentTimeMillis();
    public Message(String data){
        this.data=data;
    }


    @Override
    public String toString() {
        return "Message{" +
                "data=" + data +
                ", timeOfMsg=" + timeOfMsg +
                '}';
    }
}

class QueueBuilder {

    private static int maxSize=10;
    private static float threshold=.75f;
    private static int rwIndex=0;
    private static boolean isEnableAutoResize=false;
    private static int msgTTL=7*24*60*60; //msg allowed for 7 days
    private static int totalElement=0;
    private static String name;
    public  QueueBuilder(String name){
        this.name=name;
    }
    QueueBuilder setMessageTTL(int msgTTL){
        this.msgTTL=msgTTL;
        return this;
    }

    QueueBuilder enableAutoResize(){
        isEnableAutoResize=true;
        return this;
    }

    QueueBuilder threshold(float threshold){
        this.threshold=threshold;
        return this;
    }

    QueueBuilder initSize(int initSize){
        this.maxSize=initSize;
        return this;
    }

    Queue queue;

    public Queue create(){
        return queue=new Queue();
    }



    static class Queue{

        Map<String,Integer> groupInfo=new HashMap<>();

        public void subscribe(String groupId){
            groupInfo.put(groupId,0);
        }

        public Message poll(String groupId) throws IOException {
            if(!groupInfo.containsKey(groupId)){
                throw new IOException("Invalid consumer Id");
            }

            int index=groupInfo.get(groupId);

            Message msg=nodes[index];
            totalElement--;

            while(msg!=null&&(msg.timeOfMsg+msgTTL)<System.currentTimeMillis()){
                msg=nodes[index++];//if msg expired then read new next;
                System.out.print("asd");
                totalElement--;
            }

            if(msg!=null){
                groupInfo.put(groupId,index+1);
            }
            return msg;
        }

        public Queue(){
            nodes = new Message[maxSize];
        }

        private Message nodes[];
        public synchronized void put(Message item) throws IOException {
            if(isEnableAutoResize&&rwIndex>threshold*maxSize){
                System.err.print("Resize or QueueBuilder");
                resize();
            }

            totalElement++;
            nodes[rwIndex++]=item;
        }

        private void resize() {
            maxSize*=2;

            Message newNodes[] = new Message[maxSize];

            synchronized (newNodes){
                for (int i = 0; i < rwIndex; i++) {
                    newNodes[i]=nodes[i];
                }
                nodes=newNodes;
            }

        }
        @Override
        public String toString() {

            return "QueueBuilder{" +
                    "objectMapper=" + nodes +
                    '}';
        }
    }

    private LinkList.Node head = null;
    public void addAtEnd(int data) {
        if (head == null) {
            head = new LinkList.Node(data);
        } else {
            LinkList.Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new LinkList.Node(data);
        }
    }

    public static class Node {
        int data;
        LinkList.Node next;

        public Node(int data) {
            this.data = data;
        }

    }

}




