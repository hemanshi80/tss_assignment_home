package com.tss.test;

import com.tss.model.IBird;
import com.tss.model.IFlyable;
import com.tss.model.IWalkable;
import com.tss.model.Ostrich2;
import com.tss.model.Pigeon2;
import com.tss.model.Sparrow2;


public class BirdTest2 {

	public static void main(String[] args) {
        IBird sparrow = new Sparrow2();
        IFlyable flyingSparrow = (IFlyable) sparrow;
        IWalkable walkingSparrow = (IWalkable) sparrow;

        flyingSparrow.fly();
        walkingSparrow.walk();
        sparrow.getcolor();

        System.out.println("\n");
        
        IBird pigeon = new Pigeon2();
        IFlyable flyingPigeon = (IFlyable) pigeon;
        IWalkable walkingPigeon = (IWalkable) pigeon;

        System.out.println("\n");
        
        flyingPigeon.fly();
        walkingPigeon.walk();
        pigeon.getcolor();

        System.out.println("\n");

        IBird ostrich = new Ostrich2();
        IWalkable walkingOstrich = (IWalkable) ostrich;

        walkingOstrich.walk();
        ostrich.getcolor();
    }
}
