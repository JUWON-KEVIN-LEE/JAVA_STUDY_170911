package com.juwon.annotation_study;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class AnnotationMain {
	public static void main(String[] args) {
		UseAnnotation use = new UseAnnotation();
		use.getClass().getAnnotation(CustomAnnotation.class).key();
	}
}

// Target = ������ ��� : ������, �������, Ÿ��(Ŭ����), �Ķ����, �޼ҵ�
// Retention = Annotation ������ ���� �ܰ� �ҽ��ڵ�, Ŭ����, ��Ÿ��...

// Documented = javadoc �� ����ȭ�� element
// Inherited = ��ӵǴ� Annotation

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
	public String value() default "��";
	public String key();
}

@CustomAnnotation(key = "�߰��� key ��")
class UseAnnotation {
	
}
