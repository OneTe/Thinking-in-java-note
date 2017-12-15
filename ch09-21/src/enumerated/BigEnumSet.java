package enumerated;
//EnumSet的基础是long，一个long值有64位，而一个enum实例只需要一位bit表示其是否存在,
//但是EnumSet可以应用与多过64个元素的enum
//EnumSet is an abstract class with two private implementation classes:
//JumboEnumSet for types with more than 64 elements, and RegularEnumSet
//for types with up to 64 elements. The main factory method (entry point)
//of the EnumSet class is noneOf( ), which the other static methods also call.
//The design comes from Patterns for Encapsulating Class Trees.
//(See http://www.riehle.org/computer-science/research/1995/plop-1995- trading.html.)
//TIJ4 describes EnumSet’s very efficient bit vector representation, whereby JumboEnumSet
//uses an array of longs, while RegularEnumSet uses a single long.
import java.util.EnumSet;

/**
 * Created by wangcheng  on 2017/12/15.
 */
public class BigEnumSet {
    enum Big { A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10,
        A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21,
        A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32,
        A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43,
        A44, A45, A46, A47, A48, A49, A50, A51, A52, A53, A54,
        A55, A56, A57, A58, A59, A60, A61, A62, A63, A64, A65,
        A66, A67, A68, A69, A70, A71, A72, A73, A74, A75 }
    public static void main(String[] args) {
        EnumSet<Big> bigEnumSet = EnumSet.allOf(Big.class);
        System.out.println(bigEnumSet);
    }
}