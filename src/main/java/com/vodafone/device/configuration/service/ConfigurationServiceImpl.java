package com.vodafone.device.configuration.service;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vodafone.device.configuration.exception.DeviceAlreadyActivatedException;
import com.vodafone.device.configuration.exception.DeviceNotFoundException;
import com.vodafone.device.configuration.model.Device;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfigurationServiceImpl implements ConfigurationService {

	private final RestTemplate restTemplate;
	private static final String WAREHOUSE_URI = "http://localhost:8080/warehouse/devices/";
	private static final String STATUS_ACTIVE = "ACTIVE";

	@Override
	public Device activateDevice(Long deviceId) throws DeviceNotFoundException, DeviceAlreadyActivatedException {
		log.info("Activate device by id: " + deviceId);
		Device device = restTemplate.getForObject(WAREHOUSE_URI + deviceId, Device.class);
		if (device == null) {
			throw new DeviceNotFoundException("Device not found by id: " + deviceId);
		}
		if (STATUS_ACTIVE.equals(device.getStatus())) {
			throw new DeviceAlreadyActivatedException("Device is already activated, id: " + deviceId);
		}
		device.setTemperature((byte) new Random().nextInt(1, 11));
		device.setStatus(STATUS_ACTIVE);
		restTemplate.put(WAREHOUSE_URI + deviceId, device);
		return device;
	}

}
