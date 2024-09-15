package com.jj.hello_blog.domain.post.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.web.multipart.MultipartFile;

@Getter
@RequiredArgsConstructor
public class PostUpdateDto {

    private final int id;

    private final String title;

    private final String content;

    private final String thumbUrl;

    private final MultipartFile thumbImageFile;

    private final int categoryId;

}
