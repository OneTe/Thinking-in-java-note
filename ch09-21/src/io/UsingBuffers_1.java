package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
//交换相邻字符（支持buffer的长度是奇数了）
/**
 * Created by wangcheng  on 2017/12/8.
 */
public class UsingBuffers_1 {
    private static void symmetricScramble(CharBuffer buffer){
        while (buffer.hasRemaining()){
            buffer.mark();//将mark设置成当前position的值
            char c1 = buffer.get();
            //System.out.println(buffer.position());
            if(buffer.hasRemaining()) {
                char c2 = buffer.get();
                buffer.reset();//把position的值恢复成mark的值
                buffer.put(c2).put(c1);//先写c2，再写c1
            }else {
                buffer.reset();
                buffer.put(c1);
            }
        }
    }
    public static void main(String[] args){
        char[] data = "UsingBuffers4".toCharArray();
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
