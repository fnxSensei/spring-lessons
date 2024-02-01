package com.itmo.springproject01.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itmo.springproject01.entity.Picture;
import com.itmo.springproject01.exception.ShopException;
import com.itmo.springproject01.helper.PictureParamEditor;
import com.itmo.springproject01.service.PictureServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController // @Controller + @ResponseBody
@RequestMapping("/picture")
public class PictureController {
    private final PictureServiec pictureServiec;
    private final ObjectMapper objectMapper;

    @Autowired
    public PictureController(PictureServiec pictureServiec, ObjectMapper objectMapper) {
        this.pictureServiec = pictureServiec;
        this.objectMapper = objectMapper;
    }

    // picture: {"pictureName": "Название", "description": "Описание", "createdAt":"01-01-2024"}
    // @RequestParam + Jackson
    /*
    @PostMapping // picture: {"name": "Название", "description": ""}
    public ResponseEntity<Void> addPicture(@RequestParam String pictureString){
        ObjectMapper objectMapper = new ObjectMapper();
        Picture picture = objectMapper.readValue(pictureString, Picture.class);
    }
    */
    @GetMapping("/{pictureId}")
    public String getPictureById(@PathVariable int pictureId,
                                 Model model){
        try {
            Picture picture = pictureServiec.getPictureById(pictureId);
            model.addAttribute("pictureInfo", picture);
            return "picture"; // имя html файла, который находится в папке templates
        } catch (ShopException e) {
            throw new RuntimeException(e);
        }
    }


//    @PostMapping //файл + json
//    public ResponseEntity<Void> addPicture(@RequestPart Picture picture,
//                                           @RequestPart MultipartFile image){
//    }
    @ResponseBody
    @GetMapping("/json") //?номер_страницы=0&количество_элементов=10
    public Page<Picture> getPicturePage(@RequestParam int page, @RequestParam int size){
        pictureServiec.getPicturePage(page, size);
        return null;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Picture.class, new PictureParamEditor(objectMapper));
    }

}
