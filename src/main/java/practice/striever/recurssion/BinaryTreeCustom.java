package practice.striever.recurssion;

import java.util.*;

public class BinaryTreeCustom {

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static class BinaryTree {
		int index = -1;

		public Node makeBinaryTree(int[] nodesValue) {
			index++;
			if (index >= nodesValue.length || nodesValue[index] == -1) {
				return null;
			}
			Node newNode = new Node(nodesValue[index]);
			newNode.left = makeBinaryTree(nodesValue);
			newNode.right = makeBinaryTree(nodesValue);
			return newNode;
		}

		public void preorderTraverse(Node root) {
			if (root == null) {
				System.out.print("null->");
				return;
			}

			System.out.print(root.data + "->");
			preorderTraverse(root.left);
			preorderTraverse(root.right);

		}

		public void inorderTraverse(Node root) {
			if (root == null) {
				System.out.print("null->");
				return;
			}

			inorderTraverse(root.left);
			System.out.print(root.data + "->");
			inorderTraverse(root.right);

		}

		public void postorderTraverse(Node root) {
			if (root == null) {
				System.out.print("null->");
				return;
			}

			postorderTraverse(root.left);
			postorderTraverse(root.right);
			System.out.print(root.data + "->");

		}

		public void levelorderTraverse(Node root) {
			if (root == null) {
				System.out.println("Tree is empty");
				return;
			}
			Queue<Node> q = new LinkedList<>();
			// 1st e root node q te add korbo sathe null to identify 1st level
			q.add(root);
			q.add(null);
			// then check korbo joto khon nuh q khali ho66e
			while (!q.isEmpty()) {

				Node currNode = q.remove();

				// check korbo element null ki nuh
				if (currNode == null) {

					// next line
					System.out.println();

					// check sotti khali ki nuh
					if (q.isEmpty()) {

						break;

					} else {

						// null add korbo
						q.add(null);

					}
				} else {
					System.out.print(currNode.data + " ");

					// OBOSHYOI check korbi jate faka (null) node queue-te na dhoke
					if (currNode.left != null) {
						q.add(currNode.left);
					}
					if (currNode.right != null) {
						q.add(currNode.right);
					}
				}
			}
		}

		public int height(Node root) {

			// jdi root ba ba kono node null tahole height to 0
			if (root == null) {
				return 0;
			}

			int leftHeight = height(root.left);
			int rightHeight = height(root.right);

			return Math.max(leftHeight, rightHeight) + 1;
		}

		public int noOfNodes(Node root) {
			if (root == null) {
				return 0;
			}

			int leftNo = noOfNodes(root.left);
			int rightNo = noOfNodes(root.right);

			return leftNo + rightNo + 1;
		}

		public int sumOfNodes(Node root) {
			if (root == null) {
				return 0;
			}

			int leftSum = sumOfNodes(root.left);
			int rightSum = sumOfNodes(root.right);

			return leftSum + rightSum + root.data;
		}

		public static class infoOfNodes {
			int height;
			int diameter;

			public infoOfNodes(int h, int d) {
				this.height = h;
				this.diameter = d;
			}
		}

		public infoOfNodes getDiameter(Node root) {

			if (root == null) {
				return new infoOfNodes(0, 0);
			}

			// get left diameter height
			infoOfNodes leftNodes = getDiameter(root.left);
			infoOfNodes rightNodes = getDiameter(root.right);

			int myHeight = Math.max(leftNodes.height, rightNodes.height) + 1;
			int myDiameter = Math.max(Math.max(leftNodes.diameter, rightNodes.diameter),
					leftNodes.height + rightNodes.height + 1);
			return new infoOfNodes(myHeight, myDiameter);
		}

		// SubTree of mainTree or not
		public boolean isSubTree(Node mainTreeRoot, Node subTreeRoot) {
			// jdi 2 jonei null tahole ok
			if (mainTreeRoot == null && subTreeRoot == null) {
				return true;
			}

			// ekjon null r ekjon null noi taholei false
			if (mainTreeRoot == null || subTreeRoot == null) {
				return false;
			}

			// jdi 2 joner root data mile jai tahole check structure eki ki nuh
			if (mainTreeRoot.data == subTreeRoot.data) {
				// check identical naki
				if (isIdenticalStructure(mainTreeRoot, subTreeRoot)) {
					return true;
				}
			}

			// jdi match khelo nuh tahole main root r left right check korte hbe

			// 2 dikei khujbo
			return isSubTree(mainTreeRoot.left, subTreeRoot) || isSubTree(mainTreeRoot.right, subTreeRoot);

		}

		private boolean isIdenticalStructure(Node mainTreeRoot, Node subTreeRoot) {

			if (mainTreeRoot == null && subTreeRoot == null) {
				return true;
			}

			// ekjon null r ekjon null noi taholei false
			if (mainTreeRoot == null || subTreeRoot == null) {
				return false;
			}

			if (mainTreeRoot.data != subTreeRoot.data) {
				return false;
			}
			// 2 jon r left check korbo right check korbo ekta false holei setai answer
			else {
				return isIdenticalStructure(mainTreeRoot.left, subTreeRoot.left)
						&& isIdenticalStructure(mainTreeRoot.right, subTreeRoot.right);
			}
		}

		int indexOfSubTree = -1;

		public Node makeSubTree(int[] nodes) {
			indexOfSubTree++;
			if (indexOfSubTree >= nodes.length || nodes[indexOfSubTree] == -1) {
				return null;
			}

			Node newNode = new Node(nodes[indexOfSubTree]);
			newNode.left = makeSubTree(nodes);
			newNode.right = makeSubTree(nodes);

			return newNode;
		}

		public static class HorizontalInfo {
			int hd;
			Node node;

			public HorizontalInfo(int hd, Node node) {
				this.hd = hd;
				this.node = node;
			}
		}

		public void getTopView(Node root) {
			if (root == null) {
				System.out.println("empty tree");
				return;
			}

			Queue<HorizontalInfo> q = new LinkedList<>();
			HashMap<Integer, Node> seen = new HashMap<>();

			q.add(new HorizontalInfo(0, root));
			q.add(null);

			int min = 0;
			int max = 0;
			while (!q.isEmpty()) {
				HorizontalInfo currInfo = q.remove();
				if (currInfo == null) {
					if (q.isEmpty()) {
						break;
					} else {
						q.add(null);
					}
				} else {
					if (!seen.containsKey(currInfo.hd)) {
						seen.put(currInfo.hd, currInfo.node);
					}

					if (currInfo.node.left != null) {
						q.add(new HorizontalInfo(currInfo.hd - 1, currInfo.node.left));
						min = Math.min(min, currInfo.hd - 1);
					}

					if (currInfo.node.right != null) {
						q.add(new HorizontalInfo(currInfo.hd + 1, currInfo.node.right));
						max = Math.max(max, currInfo.hd + 1);
					}
				}
			}

			int i = min;
			for (; i <= max; i++) {
				System.out.print(seen.get(i).data + " ");
			}

		}

		public int getLowestCommonAncestor(Node a, Node b, Node root) {
			if (root == null || a == null || b == null) {
				return -1;
			}
			List<Integer> pathA = new ArrayList<>();
			// get path a
			getPath(root, a, pathA);

			List<Integer> pathB = new ArrayList<>();
			// get path b
			getPath(root, b, pathB);

			int i = 0;
			for (; i < pathA.size() && i < pathB.size(); i++) {
				if (pathA.get(i) != pathB.get(i)) {
					break;
				}
			}

			return pathA.get(i - 1);

			/*
			 * if(getPath2(root, a, pathA) && getPath2(root ,b , pathB){
			 * 
			 * int i = 0; for (; i < pathA.size() && i < pathB.size(); i++) { if
			 * (pathA.get(i) != pathB.get(i)) { break; } }
			 * 
			 * return pathA.get(i - 1); } else {return -1 ;}
			 */

		}

		private void getPath(Node root, Node given, List<Integer> path) {
			if (root == null) {
				return;
			}

			path.add(root.data);

			if (root.data == given.data) {
				return;
			}

			getPath(root.left, given, path);
			getPath(root.right, given, path);

			if (path.get(path.size() - 1) != given.data) {
				path.remove(path.size() - 1);
			}
		}

		@SuppressWarnings("unused")
		private boolean getPath2(Node root, Node given, List<Integer> path) {
			if (root == null) {
				return false;
			}

			path.add(root.data);

			if (root.data == given.data) {
				return true;
			}

			boolean isInLeft = getPath2(root.left, given, path);

			// if left here why search right
			if (isInLeft) {
				return true;
			}

			boolean isInRight = getPath2(root.right, given, path);

			// search in right
			if (isInRight) {
				return true;
			}

			// if not exist anywhere
			// backtrack remove the path we got here
			path.remove(path.size() - 1);
			return false;
		}

		public void printKthLevelNodes(int k, int level, Node root) {

			if (root == null) {
				return;
			}

			if (level == k) {
				System.out.print(root.data + " ");
				return;
			}

			printKthLevelNodes(k, level + 1, root.left);
			printKthLevelNodes(k, level + 1, root.right);
		}

		public Node lca(Node root, Node a, Node b) {
			if (root == null) {
				return root;
			}
			if (root.data == a.data || root.data == b.data) {
				return root;
			}

			Node leftSide = lca(root.left, a, b);
			Node rightSide = lca(root.right, a, b);

			if (leftSide == null) {
				return rightSide;
			}
			if (rightSide == null) {
				return leftSide;
			}

			return root;
		}

		public int getMinDistance(Node a, Node b, Node root) {
			Node lca = helper(root, a, b);

			int dist1 = distBtw(a, lca);
			int dist2 = distBtw(b, lca);

			return dist1 + dist2;
		}

		private int distBtw(Node n, Node lca) {
			if (n == null || lca == null) {
				return -1;
			}
			if (n.data == lca.data) {
				return 0;
			}

			int dist1 = distBtw(n, lca.left);
			int dist2 = distBtw(n, lca.right);

			// যদি রাইটে পাওয়া যায়, তাহলে লেফটের দূরত্বের সাথে ১ যোগ করে দাও
			if (dist1 == -1) {
				return dist2 + 1;
			}
			// যদি লেফটে পাওয়া যায়, তাহলে রাইটের দূরত্বের সাথে ১ যোগ করে দাও
			else if (dist2 == -1) {
				return dist1 + 1;
			}

			return -1;
		}

		private Node helper(Node root, Node a, Node b) {
			if (root == null || root.data == a.data || root.data == b.data) {
				return root;
			}

			Node findLeftSubtree = helper(root.left, a, b);
			Node findRightSubtree = helper(root.right, a, b);

			if (findLeftSubtree == null) { // a , b both exist on right
				return findRightSubtree;
			} else if (findRightSubtree == null) { // a, b both exist on left
				return findLeftSubtree;
			}

			// if both valid means both have in my two side then i'm the first root where
			// they exist so im the lcs

			return root;
		}

		public int getKthAncestor(Node root, Node target, int k) {
			List<Node> path = new ArrayList<>();
			boolean getPathExist = helper(root, target, path);
			if (getPathExist) {
				int indexOfKthAncestor = path.size() - 1 - k;
				if (indexOfKthAncestor >= 0) {
					return path.get(indexOfKthAncestor).data;
				} else {
					return -1;
				}
			}
			return -1;
		}

		private boolean helper(Node root, Node target, List<Node> path) {

			if (root == null) {
				return false;
			}
			if (target == null) {
				return false;
			}

			path.add(root);

			if (root.data == target.data) {
				return true;
			}

			boolean checkLeft = helper(root.left, target, path);
			if (checkLeft) {
				return true;
			}
			boolean checkRight = helper(root.right, target, path);
			if (checkRight) {
				return true;
			}

			path.remove(path.size() - 1);
			return false;
		}

		public int transformToSumTree(Node root) {
			if (root == null) {
				return 0;
			}

			int currData = root.data;

			int leftTreeSum = transformToSumTree(root.left);
			int rightTreeSum = transformToSumTree(root.right);
			root.data = leftTreeSum + rightTreeSum;
			currData = currData + leftTreeSum + rightTreeSum;

			return currData;
		}

		public void printTransformTree(Node root) {
			if (root == null) {
				return;
			}

			Queue<Node> q = new LinkedList<>();

			q.add(root);
			q.add(null);

			while (!q.isEmpty()) {
				Node curr = q.remove();
				if (curr == null) {
					System.out.println();
					if (q.isEmpty()) {
						break;
					} else {
						q.add(null);
					}
				} else {
					System.out.print(curr.data + " ");
					if (curr.left != null) {
						q.add(curr.left);
					}
					if (curr.right != null) {
						q.add(curr.right);
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		BinaryTree binaryTree = new BinaryTree();
		Node root = binaryTree.makeBinaryTree(arr);
		binaryTree.preorderTraverse(root);
		System.out.println();
		binaryTree.inorderTraverse(root);
		System.out.println();
		binaryTree.postorderTraverse(root);
		System.out.println();
		binaryTree.levelorderTraverse(root);
		System.out.println();
		System.out.println(binaryTree.height(root));
		System.out.println();
		System.out.println(binaryTree.sumOfNodes(root));
		System.out.println();
		System.out.println(binaryTree.getDiameter(root).diameter);
		System.out.println();
		BinaryTree subTree = new BinaryTree();
		Node subTreeRoot = subTree.makeSubTree(new int[] { 2, 4, -1, -1, 5, -1, -1 });
		System.out.println(subTreeRoot.data);
		System.out.println();
		binaryTree.getTopView(root);
		System.out.println();
		System.out.println();
		System.out.println(binaryTree.getLowestCommonAncestor(new Node(4), new Node(6), root));
		System.out.println();
		binaryTree.printKthLevelNodes(2, 0, root);
		System.out.println();
		System.out.println();
		System.out.println(binaryTree.lca(root, new Node(4), new Node(6)).data);
		System.out.println();
		System.out.println(binaryTree.getMinDistance(new Node(4), new Node(6), root));
		System.out.println();
		System.out.println(binaryTree.getKthAncestor(root, new Node(4), 1));
		System.out.println();
		System.out.println(binaryTree.transformToSumTree(root));
		System.out.println();
		binaryTree.printTransformTree(root);
	}
}
