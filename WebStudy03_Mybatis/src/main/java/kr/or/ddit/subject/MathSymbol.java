package kr.or.ddit.subject;


public enum MathSymbol {
	    ADD {
	        public double performOperation(double firstNum, double secondNum) {
	            return firstNum + secondNum;
	        }
	    },
	    SUBTRACT {
	        public double performOperation(double firstNum, double secondNum) {
	            return firstNum - secondNum;
	        }
	    },
	    MULTIPLY {
	        public double performOperation(double firstNum, double secondNum) {
	            return firstNum * secondNum;
	        }
	    },
	    DIVIDE {
	        public double performOperation(double firstNum, double secondNum) {
	            if (secondNum == 0) {
	                throw new ArithmeticException("0으론 나눌 수 없습니다.");
	            }
	            return firstNum / secondNum;
	        }
	    };

	    public abstract double performOperation(double firstNum, double secondNum);
	}

