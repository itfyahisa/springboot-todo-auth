package com.todo.app.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD}) //メソッド、フィールドに定義可能
@Retention(RetentionPolicy.RUNTIME) //アノテーションが実行できるタイミング アプリ実行時に利用可能
@Constraint(validatedBy=UniqueEmailValidator.class) //バリデーション制約として利用可能

public @interface UniqueEmail {

	String message() default "入力されたメールアドレスは既に登録されています。別のメールアドレスを入力してください。";
	Class<?>[] groups() default{}; //バリデーションが適用されるグループを指定する。指定なし。
	Class<? extends Payload>[] payload() default{}; //バリデーションのメタデータを保持するためのペイロードを指定する。デフォルト空の配列。
	
}
