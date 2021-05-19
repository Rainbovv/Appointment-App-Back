package com.stefanini.appointmentapp.controller;

import com.stefanini.appointmentapp.entities.DailySchedule;
import com.stefanini.appointmentapp.service.DailyScheduleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/dailySchedules")
public class DailyScheduleController {

    DailyScheduleService dailyScheduleService;

    /**
     * Constructs and initiates DailyScheduleController object with instance of DailyScheduleService.
     * @param dailyScheduleService Instance of DailyScheduleService
     */
    public DailyScheduleController(DailyScheduleService dailyScheduleService) {
        this.dailyScheduleService = dailyScheduleService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    DailySchedule create(@RequestBody DailySchedule dailySchedule) {
        return dailyScheduleService.create(dailySchedule);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    DailySchedule update(@RequestBody DailySchedule dailySchedule) {
        return dailyScheduleService.update(dailySchedule);
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody DailySchedule dailySchedule) {
        dailyScheduleService.delete(dailySchedule);
    }

    @GetMapping("/{id}")
    DailySchedule findById(@PathVariable Long id) {
        return dailyScheduleService.findById(id);
    }

    @GetMapping("")
    Set<DailySchedule> findAll() {
        return dailyScheduleService.findAll();
    }
}
