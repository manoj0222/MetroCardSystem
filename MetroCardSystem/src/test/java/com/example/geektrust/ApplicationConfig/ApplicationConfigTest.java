package com.example.geektrust.ApplicationConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.example.geektrust.Command.CommandInvoker;
import com.example.geektrust.Command.ICommand;
import com.example.geektrust.Configure.ApplicationConfig;

import junit.framework.Assert;

public class ApplicationConfigTest {



    
    ApplicationConfig applicationConfig = new ApplicationConfig();


    CommandInvoker commandInvoker = new CommandInvoker();

    @Mock
    ICommand metroCardCommand;

    @Mock
    ICommand stationCommand;

    @Mock
    ICommand passengerCommand;


    @BeforeEach
    public void registeredCommand() {
        commandInvoker.register("BALANCE", metroCardCommand);
        commandInvoker.register("CHECK_IN", passengerCommand);
        commandInvoker.register("PRINT_SUMMARY", stationCommand);
    }


    @Test
    @DisplayName("loadedCommandTest")
    public void getAllRegisteredCommands() {
        applicationConfig.loadCommands();
        // when
        CommandInvoker commandInvoker2 = applicationConfig.getCommandInvoker();
        // assert for each command
        Assert.assertTrue(commandInvoker2 instanceof CommandInvoker);

    }


}

