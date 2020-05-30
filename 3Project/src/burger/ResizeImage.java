package burger;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResizeImage {
	static int imageWidth;
	static int imageHeight;
	
	static int resizeWidth; // 변경 할 넓이
	int resizeHeight; // 변경 할 높이

	static int setWidth;
	static int setHeight;
	static double ratio;
	
	public ResizeImage(int RESIZE_WIDTH, int RESIZE_HEIGHT) {
		this.resizeWidth = RESIZE_WIDTH;
		this.resizeHeight = RESIZE_HEIGHT;
	}
	
	public static void resizeImg(String filePath, String newFilePath) {
		Image orginalImage = null;;
		try {
			orginalImage = ImageIO.read(new File(filePath));
	        imageWidth = orginalImage.getWidth(null);
            imageHeight = orginalImage.getHeight(null);
            ratio = (double)resizeWidth / (double)imageWidth;
            setWidth = (int)(imageWidth * ratio);
            setHeight = (int)(imageHeight * ratio);
            
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//2. 이미지 사이즈 수정
		Image resizeImage = orginalImage.getScaledInstance( setWidth, setHeight, Image.SCALE_SMOOTH);	//속도보다 이미지 부드러움 우선

		//(SCALE_AREA_AVERAGING, SCALE_DEFAULT, SCALE_FAST, SCALE_REPLICATE, SCALE_SMOOTH 중에 선택)

		//3. 결과물을 옮길 이미지 생성
		BufferedImage newImage = new BufferedImage( 200, 200, BufferedImage.TYPE_INT_RGB );
		//4. 생성한 이미지에 크기 수정된 이미지 그리기

		Graphics g = newImage.getGraphics();
		g.drawImage(resizeImage, 0, 0, null);
		g.dispose();

		//5. 새로 생성한 이미지를 잘라서 파일로 저장하기

		 BufferedImage dest = newImage.getSubimage(0, 0, setWidth, setHeight);
		try {
			ImageIO.write(dest, "jpg", new File(newFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
