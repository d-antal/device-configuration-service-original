package com.vodafone.device.configuration.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.device.configuration.exception.DeviceAlreadyActivatedException;
import com.vodafone.device.configuration.exception.DeviceNotFoundException;
import com.vodafone.device.configuration.model.Device;
import com.vodafone.device.configuration.service.ConfigurationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/configuration")
public class DeviceConfigurationController {

	private final ConfigurationService configurationService;

	@PutMapping("/activate/{id}")
	public Device updateDevice(@PathVariable(value = "id") Long deviceId) throws DeviceNotFoundException, DeviceAlreadyActivatedException {
		return configurationService.activateDevice(deviceId);
	}
}
