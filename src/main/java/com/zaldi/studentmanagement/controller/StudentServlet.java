package com.zaldi.studentmanagement.controller;

import com.zaldi.studentmanagement.model.dto.StudentGroupedByDept;
import com.zaldi.studentmanagement.model.entity.Student;
import com.zaldi.studentmanagement.utils.StringFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private List<Student> students;

    @Override
    public void init() throws ServletException {
        this.students = List.of(
//                comment these lines to try no data view
                new Student("S1", "Abraham", 35, "Dep 1"),
                new Student("S2", "Bartholomeo", 70, "Dep 1"),
                new Student("S3", "Cadis", 60, "Dep 1"),
                new Student("S4", "Decaprio", 90, "Dep 1"),
                new Student("S5", "Eleanor", 30, "Dep 2"),
                new Student("S6", "Ferguso", 32, "Dep 3"),
                new Student("S7", "Gregorio", 70, "Dep 3"),
                new Student("S8", "Hungaria", 20, "Dep 3")
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId != null) {
            req.setAttribute("userId", userId);
            String htmlResult = "";

            if (this.students.isEmpty()) {
                htmlResult = """
                            <tr>
                                <td colspan="4" class="table-row">Tidak ada Data</td>
                            </tr>
                        """;
            } else {
                List<StudentGroupedByDept> groupedByDepts = new ArrayList<>();
                this.students.forEach(student -> {
                    boolean found = false;
                    for (StudentGroupedByDept groupedByDept : groupedByDepts) {
                        if (student.getDepartment().equals(groupedByDept.getDeptName())) {
                            found = true;
                            groupedByDept.addStudent(student);
                            break;
                        }
                    }

                    if (!found) {
                        groupedByDepts.add(new StudentGroupedByDept(
                                student.getDepartment(),
                                List.of(student)
                        ));
                    }
                });

                htmlResult = formatToTableRows(groupedByDepts);
            }

            req.setAttribute("content", htmlResult);
            req.getRequestDispatcher("pages/students.jsp").forward(req, resp);
        } else {
            session.setAttribute("alertMessage", "Silahkan login terlebih dahulu");
            resp.sendRedirect("/");
        }
    }

    private static String formatToTableRows(List<StudentGroupedByDept> groupedByDepts) {
        StringBuilder tableResult = new StringBuilder();
        for (StudentGroupedByDept grouped : groupedByDepts) {
            tableResult.append(String.format("""
                    <tr>
                        <td rowspan="%d" class="table-row">%s</td>
                        <td class="table-row">
                            <span onclick="showData('%s')" class="student-id-btn">%s</span>
                        </td>
                        <td class="table-row">%d</td>
                        <td rowspan="%d" style="text-align: center;" class="table-row">%s</td>
                    </tr>
                    """,
                    grouped.getStudents().size(),
                    grouped.getDeptName(),
                    grouped.getStudents().get(0).getStudentName(),
                    grouped.getStudents().get(0).getStudentId(),
                    grouped.getStudents().get(0).getMark(),
                    grouped.getStudents().size(),
                    StringFormatter.dinamicComma(grouped.getPassPercentage())
                    ));

            for (int i = 1; i < grouped.getStudents().size(); i++) {
                tableResult.append(String.format("""
                        <tr>
                            <td class="table-row">
                                <span onclick="showData('%s')" class="student-id-btn">%s</span>
                            </td>
                            <td class="table-row">%d</td>
                        </tr>
                        """,
                        grouped.getStudents().get(i).getStudentName(),
                        grouped.getStudents().get(i).getStudentId(),
                        grouped.getStudents().get(i).getMark()
                        ));
            }
        }

        return tableResult.toString();
    }
}
