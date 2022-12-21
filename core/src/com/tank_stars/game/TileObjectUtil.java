package com.tank_stars.game;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.physics.box2d.*;

public class TileObjectUtil {

    private final static float PPM=32;
    private static Body pbody;
    public static Body parseTiledObjectLayer(World world, MapObjects objects){

        for(MapObject obj: objects){
            Body body;
            Shape shape;
            if(obj instanceof PolylineMapObject){
                shape=createline((PolylineMapObject) obj);
            }
            else{
                shape = null;
//                continue;
            }

            BodyDef bodyDef=new BodyDef();
            bodyDef.type=BodyDef.BodyType.StaticBody;
            body =world.createBody(bodyDef);
            body.createFixture(shape,1.0f);
            shape.dispose();


        pbody = body;
        }
        return pbody;
    }
    private static ChainShape createline(PolylineMapObject polyline){

        float[] vertices=polyline.getPolyline().getTransformedVertices();
        Vector2[] worldvertices=new Vector2[vertices.length/2];
        for(int i=0;i<worldvertices.length;i++){
            worldvertices[i]= new Vector2(vertices[i*2],vertices[i*2+1]);
        }
        ChainShape cs=new ChainShape();
        cs.createChain(worldvertices);

        return cs;
    }
}
