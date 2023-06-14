package de.uulm.sp.oop.ExpressionParser.Expression;

import de.uulm.sp.oop.ExpressionParser.Excpetions.NotANumberExpressionException;
import de.uulm.sp.oop.ExpressionParser.Excpetions.NotAnArithmeticExpressionException;
import de.uulm.sp.oop.ExpressionParser.Excpetions.NotAnOperatorException;

import javax.swing.*;

public class ArithmeticExpression extends Expression {
	private NumberExpression left;
	private Operator operator;
	private Expression right;

	private ArithmeticExpression(NumberExpression left, Operator operator, Expression right) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	public static ArithmeticExpression parse(String stringToParse) throws NotAnArithmeticExpressionException, NotANumberExpressionException, NotAnOperatorException {
		//i forgor
		return null;
	}

	private static Operator parseOperator(String stringToParse) throws NotAnOperatorException {
		if(stringToParse.contains("+"))
			return Operator.PLUS;
		else if (stringToParse.contains("-"))
			return Operator.MINUS;
		else if (stringToParse.contains("/"))
			return  Operator.DIV;
		else if (stringToParse.contains("*"))
			return Operator.MUL;
		else
			throw new NotAnOperatorException(stringToParse);
	}
	
	@Override
	public String toString() {
		return "ArithmeticExpression [left=" + left + ", operator=" + operator + ", right=" + right + "]";
	}
}
