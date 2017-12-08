package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

//交换相邻字符（字符数是偶数,不然最后c2取不到值）
//尽管可以通过对某个char数组调用wrap()方法来直接产生一个CharBuffer，但是在本例中取而代之的是
//分配一个底层的ByteBuffer，产生的CharBuffer只是ByteBuffer上的一个视图。
//需要强调我们操纵ByteBuffer为目标，因为它可以和通道进行交互
/**
 * Created by wangcheng  on 2017/12/8.
 */
public class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer){
        while (buffer.hasRemaining()){
            buffer.mark();//将mark设置成当前position的值
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();//把position的值恢复成mark的值
            buffer.put(c2).put(c1);//先写c2，再写c1
        }
    }
    public static void main(String[] args){
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
    }
}
