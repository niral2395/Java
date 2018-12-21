/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnaproject;

/**
 *
 * @author Tejas
 */
public class decryption {
    
String decrypt(String a,String b)
{
        
String ct= a;    
String dnastring= b;
int random[][]=new int[4][4];
StringBuffer converted=new StringBuffer("");
int matrix[][]= new int [4][4];
int transpose[][]= new int[4][4];
int k=0;
		//fill the matrix
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					if(k<(ct.length()))
						{
							transpose[i][j]=(int)ct.charAt(k);k++;
						}
					else{	
							transpose[i][j]=32;k++;
						}
			}
		}
	
		for(int i=0;i<dnastring.length();i++)
		if(dnastring.charAt(i)=='A' || dnastring.charAt(i)=='a')
			converted.append("00");
		else if(dnastring.charAt(i)=='C' || dnastring.charAt(i)=='c')
			 converted.append("01");
			else if(dnastring.charAt(i)=='G' || dnastring.charAt(i)=='g')
				converted.append("10");
				else if(dnastring.charAt(i)=='T' || dnastring.charAt(i)=='t')
					converted.append("11");
					else System.out.println("wrong key........");
		int pos=0;
		for(int i=0;i<4;i++)
		{
			for (int j=0;j<4;j++)
			{	if(converted.charAt(pos)=='1')
					random[i][j]=1;
				else
					random[i][j]=0;
			pos++;
			}
		}
		for(int i=0 ; i<4 ; i++)
		{
			if(i==1)
			{	
				int temp=transpose[3][1];
				transpose[3][1]=transpose[2][1];
				transpose[2][1]=transpose[1][1];
				transpose[1][1]=transpose[0][1];
				transpose[0][1]=temp;
			}
			if(i==2)
			{	
				int temp=transpose[3][2];
				transpose[3][2]=transpose[1][2];
				transpose[1][2]=temp;
				temp=transpose[2][2];
				transpose[2][2]=transpose[0][2];
				transpose[0][2]=temp;
				
				
			}
			if(i==3)
			{
				int temp=transpose[0][3];
				transpose[0][3]=transpose[1][3];
				transpose[1][3]=transpose[2][3];
				transpose[2][3]=transpose[3][3];
				transpose[3][3]=temp;
				
			}
		}
		
		for(int i=0 ; i<4 ; i++)
		{
			if(i==1)
			{
				int temp=transpose[i][3];
				transpose[i][3]=transpose[i][2];
				transpose[i][2]=transpose[i][1];
				transpose[i][1]=transpose[i][0];
				transpose[i][0]=temp;
			}
			else{
				if(i==2)
			{
				int temp=transpose[i][3];
				transpose[i][3]=transpose[i][1];
				transpose[i][1]=temp;
				temp=transpose[i][2];
				transpose[i][2]=transpose[i][0];
				transpose[i][0]=temp;
				
				
			}
			else{
				if(i==3)
			{
				int temp=transpose[i][0];
				transpose[i][0]=transpose[i][1];
				transpose[i][1]=transpose[i][2];
				transpose[i][2]=transpose[i][3];
				transpose[i][3]=temp;
			}
			}
		}
		}
		
		//calculate and display addition matrix
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					transpose[i][j] -= random[i][j];
			}
		}
		//calculate and display transpose of matrix
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{
					matrix[i][j]=transpose[j][i];
			}
		}
		String m=new String(" ");
		for(int i=0 ; i<4 ; i++)
		{
			for(int j=0 ; j<4 ; j++)
			{           
					char c=(char)matrix[i][j];
					m+=c;
			}
		}
                return m;
}
}
