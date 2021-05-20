package com.fong.forumdddcqrs.command.portadapter.api;

import com.fong.forumdddcqrs.command.application.PostApplicationService;
import com.fong.forumdddcqrs.command.application.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author AJ Catambay
 **/
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private final PostApplicationService postApplicationService;

    public PostController(PostApplicationService postApplicationService) {
        this.postApplicationService = postApplicationService;
    }

    @PostMapping(value = "")
    public ResponseEntity<String> publishPost(@RequestBody PublishPostRequest request) {
        try {
            String postId = this.postApplicationService
                    .publishPost(new PostApplicationService.PublishPostCommand(request.getSubject(), request.getBody()));

            return new ResponseEntity<String>(postId, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("an error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable("id") String id) {
        try {
            PostDTO postDTO = this.postApplicationService.getPost(new PostApplicationService.GetPostCommand(id));

            return new ResponseEntity<>(postDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
