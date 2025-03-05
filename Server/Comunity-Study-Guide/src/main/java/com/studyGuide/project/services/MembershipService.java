package com.studyGuide.project.services;

import com.studyGuide.project.dtos.Enums.Roles;
import com.studyGuide.project.entitys.Community;
import com.studyGuide.project.entitys.EnrollmentId;
import com.studyGuide.project.entitys.Membership;
import com.studyGuide.project.entitys.User;
import com.studyGuide.project.repositories.MembershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepo membershipRepo;

        public void firstMember(User admin, Community community) {

            var membership = new Membership();
            var enrollment = new EnrollmentId();

            enrollment.setUserId(admin.getId());
            enrollment.setCommunityId(community.getId());

            membership.setId(enrollment);
            membership.setCommunity_id(community);
            membership.setUser_id(admin);
            membership.setRole(Roles.ADMIN);

            var memSaved = membershipRepo.save(membership);
            community.getMembers().add(memSaved);
            admin.getMembership().add(memSaved);

        }

        public void addMembership(User user, Community community) {
            var enrollment = new EnrollmentId();
            enrollment.setCommunityId(community.getId());
            enrollment.setUserId(user.getId());

            Membership membership = new Membership(enrollment, user, community, null);

            var saved = membershipRepo.save(membership);
            community.getMembers().add(saved);
            user.getMembership().add(saved);

            community.setNum_members(community.getNum_members() + 1);
        }


        public void deleteMembership(User user, Community community) {

            List<Membership> members = community.getMembers();
            int index = 0;

            while(members.get(index).getUser_id() != user) {


                index++;
            }

            var found = members.get(index);

            members.remove(found);
            membershipRepo.delete(found);
            user.getMembership().remove(found);

        }
}
