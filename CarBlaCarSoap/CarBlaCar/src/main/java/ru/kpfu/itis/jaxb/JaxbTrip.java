package ru.kpfu.itis.jaxb;

import ru.kpfu.itis.model.Automobile;
import ru.kpfu.itis.model.Driver;
import ru.kpfu.itis.model.Trip;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by Марат on 02.05.2017.
 */
public class JaxbTrip {
    public static void main(String[] args) {

        Trip trip = new Trip();
        trip.setId((long) 1);
        trip.setDriver(new Driver());
        trip.setAuto(new Automobile());
        try {
            File file = new File("trip.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trip.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(trip, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
