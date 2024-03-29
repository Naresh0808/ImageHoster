package ImageHoster.controller;

import ImageHoster.model.Image;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class CommentController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/image/{imageId}/{imageTitle}/comments")
    public String showImage(@PathVariable("imageId") Integer id, Model model) {
        Image image = imageService.getImage(id);
        model.addAttribute("image", image);
        model.addAttribute("tags", image.getTags());
        return "images/image";
    }
}
