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
    private String status;
    private String model;
    private List<Output> output;

    @Data
    public static class Output {
        private List<Content> content;
    }

    @Data
    public static class Content {
        private String text;
    }
}
