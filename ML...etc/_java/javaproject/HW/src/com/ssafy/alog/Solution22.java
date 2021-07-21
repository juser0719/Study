package com.ssafy.alog;

import java.util.Scanner;
/*
 * 
3
9 5
6 2 4
1 5 2
0 0 4
6 6 1
2 4 3
11 6
0 0 4
6 0 1
2 4 3
4 2 4
1 5 2
10 8 1
7 5
5 2 1
1 6 2
0 6 3
1 0 2
2 4 4
 * 
 * */
class Bug {
	public int y;
	public int x;
	public int dir;
	public boolean live  = true;
	
	public Bug(int y , int x , int dir) {
		this.y = y;
		this.x = x;
		this.dir= dir;
	}
	
	public void go(int[][] map, int t) {
		
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int[] m  = {3,2,1};
		
		map[y][x] = 0;
		if (this.live == false)
			return;
		
		int nx = x + (dx[dir-1] * m[t]);
		int ny = y + (dy[dir-1] * m[t]);
		
		if( nx >= map.length || ny >= map.length || nx<0 || ny<0) {
			this.live = false;
		} else {
			if (map[ny][nx] == 0)
				map[ny][nx] = this.dir;
			else
				this.live = false;
		}
	}
	
	
	public void test() {
		System.out.println("test");
	}
}

public class Solution22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] res = new int[T];
		
		for(int t= 0 ; t< T; t++) {
			int N = sc.nextInt();
			int total = sc.nextInt();
			
			Bug[] b = new Bug[total];
			int[][] pool = new int[N][N];
			
			for(int i = 0 ; i < total ; i ++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int dir= sc.nextInt();
				
				pool[y][x] = dir;
				b[i] = new Bug(y, x, dir);
			}
			
			
			for(int time = 0 ; time < 3; time ++) {
				for(int i = 0; i < total; i++) {
					b[i].go(pool, time);
				}
			}
			int cnt = 0;
			for(int i = 0 ; i < total ;i++)
				if(b[i].live)
					cnt+= 1;
			res[t] = cnt;
			
		}
		
		
		for(int i = 0 ; i < T; i ++) {
			System.out.println("#"+(i+1)+" "+res[i]);
		}
	}
}
