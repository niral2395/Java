/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnaproject;

import java.util.Random;

/**
 *
 * @author Tejas
 */
public class project {
    String find(String s){
                String msg = s;
		int matrix[][]= new int [4][4];
		int transpose[][]= new int[4][4];
		int random[][]=new int[4][4];
		Random rand =new Random();
		String calculate_key=new String("");
		key ky=new key();
		int k=0;
		//fill the matrix
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					if(k<msg.length())
						{
							matrix[i][j]=(int)msg.charAt(k);k++;
						}
					else{	
							matrix[i][j]=32;k++;
						}
			}
		}
		
		//calculate and display transpose of matrix
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					transpose[i][j]=matrix[j][i];
			}
		}
		//calculate and display random matrix
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					random[i][j]=rand.nextInt(127);
			}
		}
                
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					random[i][j] %= 2;
			}
			 System.out.println("");
		}
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					calculate_key+=random[i][j];
			}
		}
		String calculated_key=ky.dnakey(calculate_key);
		
		//calculate and display addition matrix
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					transpose[i][j] += random[i][j];
			}
		}

		for(int i=0 ; i<4 ; i++)
		{
			if(i==1)
			{
				int temp=transpose[i][0];
				transpose[i][0]=transpose[i][1];
				transpose[i][1]=transpose[i][2];
				transpose[i][2]=transpose[i][3];
				transpose[i][3]=temp;
			}
			else{
				if(i==2)
			{
				int temp=transpose[i][0];
				transpose[i][0]=transpose[i][2];
				transpose[i][2]=temp;
				temp=transpose[i][1];
				transpose[i][1]=transpose[i][3];
				transpose[i][3]=temp;
			}
			else{
				if(i==3)
			{
				int temp=transpose[i][3];
				transpose[i][3]=transpose[i][2];
				transpose[i][2]=transpose[i][1];
				transpose[i][1]=transpose[i][0];
				transpose[i][0]=temp;	
			}
			}
		}
		}
		
		for(int i=0 ; i<4 ; i++)
		{
			if(i==1)
			{
				int temp=transpose[0][1];
				transpose[0][1]=transpose[1][1];
				transpose[1][1]=transpose[2][1];
				transpose[2][1]=transpose[3][1];
				transpose[3][1]=temp;
			}
			else if(i==2)
			{
				int temp=transpose[0][2];
				transpose[0][2]=transpose[2][2];
				transpose[2][2]=temp;
				temp=transpose[1][2];
				transpose[1][2]=transpose[3][2];
				transpose[3][2]=temp;
			}
			else if(i==3)
			{
				int temp=transpose[3][3];
				transpose[3][3]=transpose[2][3];
				transpose[2][3]=transpose[1][3];
				transpose[1][3]=transpose[0][3];
				transpose[0][3]=temp;	
			}
		}
                
                String ss="";
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					ss+=(char)transpose[i][j];
			}
		}

                ss+=",";
		ss+=calculated_key;
                return ss;
    }
}

class key
{
		String keydna=new String("");
		int i=0,j=0;
		public String dnakey(String key)
		{
			while(i!=key.length())
			{
			if(key.charAt(i)=='0' && key.charAt(i+1)=='0')
				{
					keydna+="A";
					i+=2;
				}
			else{
					if(key.charAt(i)=='0' && key.charAt(i+1)=='1')
					{
					keydna+="C";
					i+=2;
					}
					else{
						if(key.charAt(i)=='1' && key.charAt(i+1)=='0')
						{
						keydna+="G";
						i+=2;
						}
						else{
							keydna+="T";
							i+=2;
							}
						}
				}
			};
		return keydna;
		}	
}
