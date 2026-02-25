package com.knox.askgpt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateTextResponse{
    private String id;
    private String type;
    private String role;
    private List<Content> content;

    @Data
    public static class Content {
        private String type;
        private String text;
    }
}
