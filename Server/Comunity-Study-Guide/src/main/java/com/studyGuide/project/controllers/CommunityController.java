package com.studyGuide.project.controllers;

import com.studyGuide.project.entitys.Community;
import com.studyGuide.project.repositories.CommunityRepo;
import com.studyGuide.project.services.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityRepo communityRepo;

    @Autowired
    private CommunityService communityService;


    @PostMapping("/create")
    public ResponseEntity<Community> createCommunity(@RequestBody Long id, String name) {
    return ResponseEntity.status(HttpStatus.OK).body(communityService.createCommunity(id, name));
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinCommunity(@RequestBody Long user_id, Long community_id) {
        return ResponseEntity.status(HttpStatus.OK).body(communityService.addMember(user_id, community_id));
    }

    @DeleteMapping("/kick")
    public ResponseEntity<String> kickMember(Long id, Long community_id) {
        return ResponseEntity.status(HttpStatus.OK).body(communityService.kickMember(id, community_id));
    }

}
