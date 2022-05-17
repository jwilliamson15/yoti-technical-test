package org.yoti.yotitechnicaltest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yoti.yotitechnicaltest.models.HooverRequest;
import org.yoti.yotitechnicaltest.models.HooverResult;
import org.yoti.yotitechnicaltest.models.RoboticHoover;
import org.yoti.yotitechnicaltest.models.Room;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class HooverService {

    @Autowired
    DatabaseService databaseService;

    private static Room room = new Room();
    private static RoboticHoover notRoomba = new RoboticHoover();
    private static int patchesCount = 0;

    public HooverResult doTheHoovering(HooverRequest request) {
        patchesCount = 0;
        room.setRoomXDimension(request.getRoomSize().getX());
        room.setRoomYDimension(request.getRoomSize().getY());
        room.setDirtPatches(request.getPatches());
        //TODO - throw room position exception
        notRoomba.setPosition(request.getCoords());

        moveHoover(request.getInstructions());

        HooverResult result = new HooverResult();
        result.setCoords(notRoomba.getPosition());
        result.setPatches(patchesCount);
        return result;
    }

    private static void moveHoover(String instructionString) {
        char[] instructions = instructionString.toCharArray();

        for (char instruction: instructions) {
            switch (instruction) {
                //TODO - ENUM for movement direction
                case 'N':
                    if (!(notRoomba.getPosition().getY() + 1 > room.getRoomYDimension())){
                        notRoomba.getPosition().setY(notRoomba.getPosition().getY() + 1);
                        cleanDirtPatch();
                    }
                    break;
                case 'E':
                    if (!(notRoomba.getPosition().getX() + 1 > room.getRoomXDimension())) {
                        notRoomba.getPosition().setX(notRoomba.getPosition().getX() + 1);
                        cleanDirtPatch();
                    }
                    break;
                case 'S':
                    if (!(notRoomba.getPosition().getY() - 1 < 0)) {
                        notRoomba.getPosition().setY(notRoomba.getPosition().getY() - 1);
                        cleanDirtPatch();
                    }
                    break;
                case 'W':
                    if (!(notRoomba.getPosition().getX() - 1 < 0)) {
                        notRoomba.getPosition().setX(notRoomba.getPosition().getX() - 1);
                        cleanDirtPatch();
                    }
                    break;
            }
        }
    }

    private static void cleanDirtPatch() {
        if (room.getDirtPatches().contains(notRoomba.getPosition())) {
            patchesCount++;
            room.getDirtPatches().remove(notRoomba.getPosition());
        }
    }
}
