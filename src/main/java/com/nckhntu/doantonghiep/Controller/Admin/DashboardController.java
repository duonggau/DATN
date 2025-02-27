package com.nckhntu.doantonghiep.Controller.Admin;

import com.nckhntu.doantonghiep.Repository.AppointmentRepository;
import com.nckhntu.doantonghiep.Repository.PetRepository;
import com.nckhntu.doantonghiep.Repository.ServiceRepository;
import com.nckhntu.doantonghiep.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class DashboardController {
    private final UserRepository userRepository;
    private final PetRepository petRepository;
    private final AppointmentRepository appointmentRepository;
    private final ServiceRepository serviceRepository;

    public DashboardController(UserRepository userRepository, PetRepository petRepository, AppointmentRepository appointmentRepository, ServiceRepository serviceRepository) {
        this.userRepository = userRepository;
        this.petRepository = petRepository;
        this.appointmentRepository = appointmentRepository;
        this.serviceRepository = serviceRepository;
    }

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("totalUsers", (int) userRepository.count());
        model.addAttribute("totalServices", (int) serviceRepository.count());
        model.addAttribute("totalPets", (int) petRepository.count());
        model.addAttribute("totalAppointment", (int) appointmentRepository.count());
        return "Admin/dashboard";
    }
}
