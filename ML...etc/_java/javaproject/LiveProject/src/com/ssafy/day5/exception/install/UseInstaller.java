package com.ssafy.day5.exception.install;

/**
 * @since 2021. 7. 7.
 */
public class UseInstaller {
    public static void main(String[] args) {
        // TODO: InstallApp을 이용하면서 자원이 확실히 정리되도록 해보자.
    	InstallApp install = new InstallApp();
    	
    	install.copy();
    	try {
			install.install();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		} finally {
			install.delete();
		}
        // END:
        System.out.println("설치 종료");

    }
}
