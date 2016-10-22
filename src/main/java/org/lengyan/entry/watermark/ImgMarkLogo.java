package org.lengyan.entry.watermark;

import org.lengyan.currency.common.watermark.ImgMarkLogoByIcon;
import org.lengyan.currency.common.watermark.ImgMarkLogoByWord;

/**
 * 图片添加水印
 * @author ktc
 * 2016年10月20日 上午11:08:08
 */
public class ImgMarkLogo {
	
	public static void main(String[] args) {
		String srcImgPath = "E:/学习/img/xifan001.png";
        String iconPath = "E:/学习/img/logo.png";
        String targerPath = "E:/学习/img/xifan001_mark_icon.jpg";
        String targerPath2 = "E:/学习/img/xifan001_mark_icon_rotate.jpg";
        String targerPath3 = "E:/学习/img/xifan001_mark_icon_word.jpg";
        
        // 给图片添加水印(图片)
        ImgMarkLogoByIcon.markImageByIcon(iconPath, srcImgPath, targerPath);
        // 给图片添加水印(图片),水印旋转-25
        ImgMarkLogoByIcon.markImageByIcon(iconPath, srcImgPath, targerPath2, -25);
        // 给图片添加水印(文字),水印旋转-25
        ImgMarkLogoByWord.markImageByWord("稀饭水印,请勿翻版", srcImgPath, targerPath3);
    }
}
