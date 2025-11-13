
package slidingwindowprotocol;

import java.util.Arrays;
public class SlidingWindowProtocol {
        private int windowSize;
        private int[] frames;
        private boolean[] ack;
        public SlidingWindowProtocol(int windowSize,int frameCount){
            this.windowSize=windowSize;
            this.frames=new int[frameCount];
            this.ack=new boolean[frameCount];
            for(int i=0;i<frameCount;i++){
            frames[i]=i;
            ack[i]=false;
        }
        }
        public void sendFrames(){
            int sendIndex=0;
            while(sendIndex<frames.length){
                for(int i=0;i<windowSize && (sendIndex+i)<frames.length;i++){
                   System.out.println("Sending frame:"+frames[sendIndex+i]);
                }
                for(int i=0;i<windowSize&&(sendIndex+i)<frames.length;i++){
                    ack[sendIndex+i]=receiveAck(sendIndex+i);
                    
                }
                while(sendIndex<frames.length&&ack[sendIndex]){
                    sendIndex++;
                }
        }
            
    }
        private boolean receiveAck(int frame){
            System.out.println("Receiving ack for frame:"+frame);
            return true;
        }
        private int receiveCumulativeAck(int lastFrameSent) {
    int cumulativeAck = lastFrameSent + 1;
    System.out.println("Receiving ack" + cumulativeAck);
    return cumulativeAck;
}
    

public static void main(String[] args){
int windowSize=6;
int frameCount=10;
SlidingWindowProtocol swp=new SlidingWindowProtocol(windowSize,frameCount);
if(windowSize<=(frameCount/2)){
  swp.sendFrames();  
}
else{
    System.out.print("error");
}
}
}

//1.need to check size of the window less than are equal to half of the window frame. windowsize<=1/2 framecount,5<=10
//2.if you send two frames 0 1 2 3 sending frames means getting the acknowledgement is 4(ack number)
//SENDER 0,1,2 RECEIVER ack -3