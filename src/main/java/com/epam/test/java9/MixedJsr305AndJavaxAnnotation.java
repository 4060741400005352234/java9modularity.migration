package com.epam.test.java9;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import com.fasterxml.classmate.TypeResolver;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Generated("NIPA-TYPING")
public class MixedJsr305AndJavaxAnnotation {

    public static void main(String[] args) {
        System.out.println(message());
    }

    @Nonnull
    public static String message() {
        return "Hello, JSR 305 and javax.annotations";
    }

    private void createDocket(String name, String groupName, Predicate<String> selector) {
        Object a = DocumentationType.SWAGGER_2;
    }




    private Docket createDocket(String name, String groupName) {
        ApiInfo apiInfo = new ApiInfoBuilder().title(name).build();
        TypeResolver typeResolver = new TypeResolver();
        AlternateTypeRule rule = AlternateTypeRules.newRule(
                typeResolver.resolve(Collection.class, WildcardType.class),
                typeResolver.resolve(List.class, WildcardType.class));

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .build()
                .directModelSubstitute(LocalDateTime.class, String.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .alternateTypeRules(rule);
        if (groupName != null) {
            docket.groupName(groupName);
        }
        return docket;
    }
}
