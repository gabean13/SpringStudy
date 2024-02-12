package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
    /**
     * 회원 목록 조회: GET /mapping/users
     * 회원 등록: POST /mapping/users
     * 회원 조회: GET /mapping/users/id1
     * 회원 수정: PATCH /mapping/users/id1
     * 회원 삭제: DELETE /mapping/users/id1
     */

    @GetMapping
    public String getUsers() {
        return "get users";
    }

    @PostMapping()
    public String addUser() {
        return "add user";
    }

    @GetMapping("/{userid}")
    public String getUser(@PathVariable String userid) {
        return "get user = " + userid;
    }

    @PatchMapping("/{userid}")
    public String patchUser(@PathVariable String userid) {
        return "fix user = " + userid;
    }

    @DeleteMapping("/{userid}")
    public String deleteUser(@PathVariable String userid) {
        return "delete user = " + userid;
    }
}
