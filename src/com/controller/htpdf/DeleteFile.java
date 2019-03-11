package com.controller.htpdf;
import java.io.File;
//文件删除
public class DeleteFile {
	/**
	 * @Description: 递归删除文件  或者 目录下的文件
	 */
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {//测试此抽象路径名表示的文件是否是一个目录。
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {//没有删除成功返回false
					return false;
				}
			}
		}
		return dir.delete();//当且仅当成功删除文件或目录时，返回 true；否则返回 false 
	}
}
