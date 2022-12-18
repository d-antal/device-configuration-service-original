package com.vodafone.device.configuration.service;

import org.springframework.web.client.RestClientException;

import com.vodafone.device.configuration.exception.DeviceAlreadyActivatedException;
import com.vodafone.device.configuration.exception.DeviceNotFoundException;
import com.vodafone.device.configuration.model.Device;

public interface ConfigurationService {

	Device activateDevice(Long deviceId) throws DeviceNotFoundException, DeviceAlreadyActivatedException, RestClientException;
}
