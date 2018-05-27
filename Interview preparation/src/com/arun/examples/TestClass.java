package com.arun.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

class TestClass {

	static boolean DFS(int i, int n)

	{

		visited[i] = true;

		if (l[i] != null)

		{

			for (int j : l[i])

			{

				if (!visited[j])

				{

					if (DFS(j, n))

					{

						return true;

					}

				}

			}

			for (int k = 0; k < n; k++)

			{

				if (!visited[k])

				{

					visited[i] = false;

					return false;

				}

			}

			return true;

		}

		visited[i] = false;

		return false;

	}

	static ArrayList<Integer>[] l;

	static boolean[] visited;

	@SuppressWarnings("unchecked")

	public static void main(String args[]) throws Exception, IOException

	{

		NScanner sc = new NScanner(System.in);

		int t = sc.nextInt(), n, m;

		while (t-- > 0)

		{

			n = sc.nextInt();

			m = sc.nextInt();

			l = new ArrayList[n];

			while (m-- > 0)

			{

				int s = sc.nextInt() - 1;

				int d = sc.nextInt() - 1;

				if (l[s] == null)

					l[s] = new ArrayList<Integer>();

				if (l[d] == null)

					l[d] = new ArrayList<Integer>();

				l[s].add(d);

				l[d].add(s);

			}

			visited = new boolean[n];

			boolean flag = false;

			for (int i = 0; i < n; i++)

			{

				if (!visited[i])

				{

					if (DFS(i, n))

					{

						flag = true;

						break;

					}

				}

			}

			if (flag)

				System.out.println("Yes");

			else

				System.out.println("No");

		}

		sc.close();

	}

}

class NScanner {

	private InputStream mIs;

	private byte[] buf = new byte[1024];

	private int curChar;

	private int numChars;

	// static StringBuilder mod = new StringBuilder("");

	public NScanner() {

		this(System.in);

	}

	public NScanner(InputStream is) {

		mIs = is;

	}

	public int read() {

		if (numChars == -1)

			throw new InputMismatchException();

		if (curChar >= numChars) {

			curChar = 0;

			try {

				numChars = mIs.read(buf);

				// System.out.println(Arrays.toString(buf));

			} catch (IOException e) {

				throw new InputMismatchException();

			}

			if (numChars <= 0)

				return -1;

		}

		return buf[curChar++];

	}

	public String nextLine() {

		int c = read();

		while (isSpaceChar(c))

			c = read();

		StringBuilder res = new StringBuilder();

		do {

			res.appendCodePoint(c);

			c = read();

		} while (!isEndOfLine(c));

		return res.toString();

	}

	public String nextString() {

		int c = read();

		while (isSpaceChar(c))

			c = read();

		StringBuilder res = new StringBuilder();

		// mod.setLength(0);

		do {

			res.appendCodePoint(c);

			// if(Character.isUpperCase(c))

			// mod.appendCodePoint(c);

			c = read();

		} while (!isSpaceChar(c));

		return res.toString();

	}

	public char nextChar() {

		int c = read();

		while (isSpaceChar(c))

			c = read();

		return (char) c;

	}

	public char nextSimpleChar() {

		int c = read();

		return (char) c;

	}

	public long nextLong() {

		int c = read();

		while (isSpaceChar(c))

			c = read();

		int sgn = 1;

		if (c == '-') {

			sgn = -1;

			c = read();

		}

		long res = 0;

		do {

			if (c < '0' || c > '9')

				throw new InputMismatchException();

			res *= 10;

			res += c - '0';

			c = read();

		} while (!isSpaceChar(c));

		return res * sgn;

	}

	public int nextInt() {

		int c = read();

		while (isSpaceChar(c))

			c = read();

		int sgn = 1;

		if (c == '-') {

			sgn = -1;

			c = read();

		}

		int res = 0;

		do {

			if (c < '0' || c > '9')

				throw new InputMismatchException();

			res *= 10;

			res += c - '0';

			c = read();

		} while (!isSpaceChar(c));

		return res * sgn;

	}

	public boolean isSpaceChar(int c) {

		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;

	}

	public boolean isEndOfLine(int c) {

		return c == '\n' || c == '\r' || c == -1;

	}

	public void close() throws IOException

	{

		mIs.close();

	}

	public int available() throws IOException {
		return mIs.available();
	}

}