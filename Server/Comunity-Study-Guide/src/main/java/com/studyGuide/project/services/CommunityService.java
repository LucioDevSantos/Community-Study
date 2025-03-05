package com.studyGuide.project.services;


import com.studyGuide.project.Utils.Utils;
import com.studyGuide.project.dtos.Enums.Roles;
import com.studyGuide.project.entitys.Community;
import com.studyGuide.project.entitys.EnrollmentId;
import com.studyGuide.project.entitys.Membership;
import com.studyGuide.project.entitys.User;
import com.studyGuide.project.repositories.CommunityRepo;
import com.studyGuide.project.repositories.MembershipRepo;
import com.studyGuide.project.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepo communityRepo;

    @Autowired
    private Utils utils;

    @Autowired
    private MembershipService membershipService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MembershipRepo membershipRepo;

    public Community createCommunity(Long id, String name) {
        var community = new Community();
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found by id"));


        community.setAdmin_id(id);
        community.setName(name);
        community.setNum_code(utils.codeGenerator());
        community.setCode(utils.URLCodeGenerator(8));
        community.setNum_members(1);
        Community saved = communityRepo.save(community);
        try {
            membershipService.firstMember(user, saved);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return saved;
    }

    public String addMember(Long id, Long comm_id) {
        User new_member = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("user not found"));
        Community community = communityRepo.findById(comm_id).orElseThrow(()-> new IllegalArgumentException("community not found"));
        try {
            membershipService.addMembership(new_member, community);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "Successfully joined member";
    }

    public String kickMember(Long user_id, Long community_id) {
        User user = userRepo.findById(user_id).orElseThrow(() -> new IllegalArgumentException("user not found"));
        Community community = communityRepo.findById(community_id).orElseThrow(() -> new IllegalArgumentException("community not found"));

        try {
            membershipService.deleteMembership(user, community);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "member successfully kicked";
    }
}
