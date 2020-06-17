import java.util.*;
class theFigureGuess {
	/*
	1. 用户输入多少人参与猜拳（2~5人）
	2. 计算机控制除1个玩家以外的其他人出拳
	3. 每次出拳比较后，输的人被淘汰，剩余玩家继续出拳直到一人胜出。
	4. 每次比较后，输出每个玩家（编号）的出拳和胜负情况
	*/
	//1表示拳头 2表示剪刀 3表示布
	//场上只能同时出现两种，如果有三种 继续

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入几个人猜拳(2~5人):");
		int num = sc.nextInt();
		int[] result = new int[5];

		//判断输入是否合法
		if (num < 2 || num > 5) {
			System.out.println("请输入正确的人数!");
		}

		System.arraycopy(countResult(num), 0, result, 0, num);
		System.out.println("==========未排序前==========");
		for (int i = 0; i < num; i++) {
			System.out.println(result[i]);
		}

		//判断数组中是否出现三种拳
		boolean isThree = false;
		isThree = isReapeat(result, num - 1);

		//如果出现了再来一波
		while (isThree == true) {
			System.arraycopy(countResult(num), 0, result, 0, num - 1);
			System.out.println("==========未排序前==========");
			for (int i = 0; i < num; i++) {
				System.out.println(result[i]);
			}

			//判断数组中是否出现三种拳
			isThree = isReapeat(result, num - 1);
			if (isThree == false) {
				break;
			}
		}
		// getResult(result, num);

		//判断是否继续进行同样的操作
		boolean isSingle = false;
		int tempLen = getResult(result, num);
		int[] tempResult = new int[num];
		if (tempLen == 1) {
			isSingle = true;
		}
		while (!isSingle) {

			System.arraycopy(result, 0, tempResult, 0, num);
			System.out.println("==========未排序前==========");
			for (int i = 0; i < num; i++) {
				if (tempResult[i] != 0) {
					System.out.println("第" + (i + 1) + "个是" + tempResult[i]);
				}
			}

			//判断数组中是否出现三种拳
			isThree = isReapeat(tempResult, num - 1);
			System.out.println(isThree);


			// //如果出现了再来一波
			while (isThree == true) {
				System.arraycopy(countResult(tempLen), 0, tempResult, 0, num);

				//判断数组中是否出现三种拳
				isThree = isReapeat(tempResult, num - 1);
				if (isThree == false) {
					break;
				}

				System.out.println("==========未排序前==========");
				for (int i = 0; i < num; i++) {
					if (tempResult[i] != 0) {
						System.out.println("第" + (i + 1) + "个是" + tempResult[i]);
					}
				}
			}
			break;

			// for (int i = 0; i < tempLen - 1; i++) {
			// 	if (tempResult[i] == 0) {
			// 		tempResult[i] = tempResult[i + 1];
			// 		tempResult[i + 1] = 0;
			// 	}
			// }

			// tempLen = getResult(tempResult, tempLen);
			// if (tempLen == 1) {
			// 	isSingle = true;
			// 	break;
			// }
		}


	}

	//计算猜拳结果
	public static int getResult(int[] result, int len) {
		System.out.println("=======计算猜拳结果========");
		int[] temp = new int[len];
		System.arraycopy(result, 0, temp, 0, len);
		int index = len;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				//如果result[i] == 1 2删掉，3留下删1
				if (result[i] == 1 && result[j] == 2 || result[i] == 2 && result[j] == 3 || result[i] == 3 && result[j] == 1) {
					result[j] = 0;
					index--;//记录剩下几个元素
				}

			}

		}
		for (int i = 0; i < len; i++) {
			if (result[i] == 0) {
				String tempp = "";
				switch (temp[i]) {
				case 1:
					tempp = "拳头";
					break;
				case 2:
					tempp = "剪刀";
					break;
				case 3:
					tempp = "布";
					break;
				}
				System.out.println("第" + (i + 1) + "号出了" + tempp + "输了" );
			} else {
				String tempp = "";
				switch (temp[i]) {
				case 1:
					tempp = "拳头";
					break;
				case 2:
					tempp = "剪刀";
					break;
				case 3:
					tempp = "布";
					break;
				}
				System.out.println("第" + (i + 1) + "号出了" + tempp + "赢了");
			}

		}
		return index;
	}

	//统计猜拳结果
	public static int[] countResult(int num) {
		//用户输入剪子石头布
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要出什么:(1表示拳头 2表示剪刀 3表示布)");
		int userGuess = sc.nextInt();
		int index = 0;
		int[] result = new int[5];

		//系统随机帮其他人出拳
		for (int i = 0; i < num - 1; i++) {
			Random random = new Random();
			result[i] = randomInt(1, 4, random);
			index = i;
		}
		result[num - 1] = userGuess;

		return result;
	}

	//统计猜拳结果有数组传进来的方法
	// public static int[] countResult(int[] arr) {
	// 	//用户输入剪子石头布
	// 	Scanner sc = new Scanner(System.in);
	// 	System.out.println("请输入您要出什么:(1表示拳头 2表示剪刀 3表示布)");
	// 	int index = 0;
	// 	int userGuess = sc.nextInt();

	// 	//系统随机帮其他人出拳
	// 	for (int i = 0; i < arr.length; i++) {
	// 		Random random = new Random();
	// 		if (arr[i] == 0) {
	// 			break;
	// 		}
	// 		result[i] = randomInt(1, 4, random);
	// 		index = i;
	// 	}
	// 	result[index + 1] = userGuess;

	// 	return result;
	// }

	public static int randomInt(int from, int where, Random ran) {
		int n = where - from;
		if (n > 0) {
			return ran.nextInt(n) + from;
		} else {
			int r = 0;
			do {
				r = ran.nextInt();
			} while (r < from || r >= where);

			return r;
		}
	}

	public static boolean isReapeat(int[] result, int len) {
		//首先遍历数组中是否出现三种
		boolean isReap = false;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;


		for (int i = 0; i <= len; i++) {

			switch (result[i]) {
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			case 3:
				count3++;
				break;
			}

		}

		if (count1 >= 1 && count2 >= 1 && count3 >= 1) {
			System.out.println("出现了三种不一样的拳");
			return isReap = true;
		} else if (count1 == 0 && count2 == 0 && count3 != 0 || count2 != 0 && count1 == 0 && count3 == 0 || count1 != 0 && count2 == 0 && count3 == 0) {
			System.out.println("全部拳都一样");
			return isReap = true;
		}


		return isReap = false;

	}
}