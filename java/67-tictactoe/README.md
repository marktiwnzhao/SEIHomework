TicTacToe

两个玩家，一个打叉(X)，一个打圈(O)， 轮流在n乘n的格上打自己的符号，n最多9，最少为3，注意棋盘是方的。
游戏落子有两种模式：
1.正常规则落子 
2.当棋盘上己方已经落下5个子，之后在落下一个子之前，要移去第1个子。即棋盘上最多出现5个己方棋子。

游戏胜利条件有两种模式：
1.己方棋子横、竖、斜三个字连成一线即赢，若棋盘填满双方仍未分胜负则为平局
2.己方棋子横、竖三个字连成一线即赢，若棋盘填满双方仍未分胜负则为平局

我们在游戏开始时， 即Game类的playGame方法中会传入gamemode字符串来选择游戏模式，gamemode字符串长度为2，每个字符都只有0或1两种可能，其中第一个字符代表落子模式，第二个字符代表胜负条件
00：正常规则落子，横竖斜均能胜利
01：正常规则落子，横竖能胜利
10：5子模式，横竖斜均能胜利
11: 5子模式，横竖能胜利


本文件夹内附带的示意图是一个X方取胜的例子。其中棋盘大小为3*3，正常落子，横竖斜均可胜利

要求：

1. 基本要求
请从面向对象思想出发利用Java语言实现这个Tic-Tac-Toe游戏。
为了便于识别棋子的位置，棋盘上行以1至9表示，列以A至I表示，根据棋盘大小，行从1开始计数，列从A开始记字母
下图中棋盘大小为4*4,O玩家分别在B1,B3,C4落子。坐标每次落子之后显示如下图案（X玩家用大写X，O玩家用大写O，空子用下划线表示，每一个字符之间用空格隔开，A左边有两个空格，每一行结束都有一个换行符）：
  A B C D
1 X O _ _
2 _ _ X _
3 _ O X _
4 _ _ O X
我们已提供部分代码。请添加并修改你觉得需要的其它类和方法，完成该游戏。

2. 输出规定与判题方法
在进行判题时，我们会调用你的Game类的playGame(String gameMode, String moveStr, int size)方法，传入游戏模式字符串(例如01)，和下棋指令字符串(例如A1,B1,B2,B3,C3)，以及棋盘大小n(棋盘是方的)
你的程序需要从标准输出中输出如下内容：
  A B C
1 X _ _
2 _ _ _
3 _ _ _
  A B C
1 X O _
2 _ _ _
3 _ _ _
  A B C
1 X O _
2 _ X _
3 _ _ _
  A B C
1 X O _
2 _ X _
3 _ O _
  A B C
1 X O _
2 _ X _
3 _ O X
playGame方法除了要输出棋盘的状态变化以外，还要返回比赛结果。
可以看到，在示例中X玩家胜利，因此返回Result.X_WIN

我们会同时检查【playGame方法返回的比赛结果】与【标准输出的内容】作为判题的依据。

3. 注意事项

* X玩家先走
* 棋局不一定结束。比如传入的测试字符串是A2，只下了一步棋，这时比赛结果应该返回Result.GAMING
* 当在已经放置棋子的地方下棋，例如(A1,A1),则返回Result.ERROR

4.额外说明
本题中棋盘的大小、落子的策略以及判断输赢的策略会发生改变
对于落子和判断输赢未来可能会添加新的策略，为了应对这种变更需要更加灵活的设计，请自行添加修改相应的类、接口以及继承关系来完成设计应对变更
本题不仅可以修改已有的文件，还可以添加任意多的文件，甚至删去已有的文件，实现方式自行选择(若要删去文件，请不要删去要测试方法所在的类)
题目中的3*3仅为范例，需要灵活修改。