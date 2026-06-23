package com.practice.algorithm.leetcode.Hot100.easy.p20_isValid;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	/*public boolean isValid(String s) {

	    //考研和408里面碰到过,我记得是通过设置优先级来判断进入和弹出,但具体我有点模糊了---优先级的设定
	    //这个只是判断合不合法---但是也得有优先级,不然嵌套的不行,不需要了,那优先级是什么来着?
		// 这个只要记录栈顶的和下一个是否匹配就行了
		Deque<Character> deque=new ArrayDeque<>();
        //感觉还是有优先级更好,也不是优先级,就是相同左右括号的匹配标志,但是怎么设置呢?
		char[] left={'(','[','{'};
		char[] right={')',']','}'};
		for (char cur:s.toCharArray()){
			if(!deque.isEmpty()){
				deque.push(cur);
			}else {
			}
		}

		return false;

	}*/

	public boolean isValid(String s) {

		//貌似只用一个栈就行了--还需要其他的吗?应该需要记录一下吗?如果和栈里面不对付的话直接就false了吧
		Deque<Character> deque=new ArrayDeque<>();
		//就是匹配怎么快速匹配上--就还是卡住这一个
		for (char c:s.toCharArray()){
			//三者
			if(c=='('){

			}

		}


		return true;

	}

}
