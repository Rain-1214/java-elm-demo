package com.elm.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomValidateCode {

	private Random random = new Random();
	private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //��֤��ȡֵ��Χ
			
	private int width = 80;
	private int height = 30;
	private int stringNum = 4;
	private int lineSize = 5;
	
	/**
	 * ��ȡ����ַ�������
	 * @param index
	 * @return
	 */
	public String getRandomChar(int index){
		return String.valueOf(randString.charAt(index));
	}
	
	/**
	 * ��ȡ����
	 * @return
	 */
	private Font getFont(){
		return new Font("Fixedsys",Font.CENTER_BASELINE,18);
	}
	
	/**
	 * ��ȡ��ɫ
	 * @param frontColor
	 * @param backColor
	 * @return
	 */
	private Color getRandColor(int frontColor,int backColor) {
		if(frontColor > 255){
			frontColor = 255;
		}
		if(backColor > 255) {
			backColor = 255;
		}
		
		int red = frontColor + random.nextInt(backColor - frontColor - 16);
		int green = frontColor + random.nextInt(backColor - frontColor - 14);
		int blue = frontColor + random.nextInt(backColor - frontColor -18);
		
		return new Color(red,green,blue);
		
	}
	
	private int getRandomIntColor() {
        int[] rgb = getRandomRgb();
        int color = 0;
        for (int c : rgb) {
            color = color << 8;
            color = color | c;
        }
        return color;
    }
	
	private int[] getRandomRgb() {
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }
	
	/**
	 * �����ַ���
	 * @param g
	 * @param randomString
	 * @param i
	 * @return
	 */
	private String drawString(Graphics g,String randomString,int i){
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101),random.nextInt(111),random.nextInt(121)));
		String randChar = String.valueOf(getRandomChar(random.nextInt(randString.length())));
		randomString += randChar;
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(randChar, 13*i, 16);
		return randomString;
	}
	
	
	/**
	 * ���Ƹ�����
	 * @param g
	 */
	private void drawLine(Graphics g){
		int x = random.nextInt(width - 1);
        int y = random.nextInt(height - 1);
        int x1 = random.nextInt(6) + 1;
        int y1 = random.nextInt(12) + 1;
        g.drawLine(x, y, x + x1 + 40, y + y1 + 20);
		
		g.drawLine(x, y, x1, y1);
		
	}
	
	
	public void getRandomCode(HttpServletRequest request,HttpServletResponse response,String key){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);  
		Graphics g = image.getGraphics();// ���BufferedImage�����Graphics����  
		g.fillRect(0, 0, width, height);//������  
		Color backgroundColor = getRandColor(200, 250);
        g.setColor(backgroundColor);// ���ñ���ɫ
        g.fillRect(0,0, width, height);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));//��������  
		g.setColor(getRandColor(110, 133));//������ɫ  

		//���Ƹ�����  
		for(int i = 0; i <= lineSize; i++) {  
		    drawLine(g);  
		}  
		float yawpRate = 0.05f;// ������
        int area = (int) (yawpRate * width * height);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int rgb = getRandomIntColor();
            image.setRGB(x, y, rgb);
        }		
		//�����ַ�  
		String randomString = "";  
		for(int i = 1; i <= stringNum; i++) {  
		    randomString = drawString(g, randomString, i);  
		}  
		  
		//�����ɵ���֤�����session  
		String sessionId = request.getSession().getId();//��ȡsession��id  
		request.getSession().setAttribute(sessionId+key, randomString);  
		System.out.println("���ɵ���֤��Ϊ��" + randomString);  
		  
		g.dispose();//�ͷŻ�ͼ��Դ  
		try {  
		    ByteArrayOutputStream tmp = new ByteArrayOutputStream();  
		    ImageIO.write(image, "png", tmp);//����ֵ��ͼƬ�������  
		    tmp.close();  
		    Integer contentLength = tmp.size();//���ݳ���  
		    response.setHeader("content-length", contentLength+"");  
		    response.getOutputStream().write(tmp.toByteArray());//ͨ��response���ͼƬ  
		} catch (Exception e) {  
		    e.printStackTrace();  
		} finally {  
		    try {  
		        response.getOutputStream().flush();  
		        response.getOutputStream().close();  
		    } catch (Exception e2) {  
		        e2.printStackTrace();  
		    }  
		}     
		
	}
	

}
