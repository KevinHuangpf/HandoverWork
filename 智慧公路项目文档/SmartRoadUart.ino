void setup() {
    Serial.begin(115200);               //initial the Serial
    Serial1.begin(115200);               //initial the Serial
    Serial2.begin(115200);               //initial the Serial
    
}

void loop()
{

  
     //转发串口0的数据
    if(Serial.available())
    {
         Serial.write(Serial.read()); 
  
    }

    //转发串口1的数据
    if(Serial1.available())
    {
         Serial.write(Serial1.read()); 
  
    }
    //转发串口2的数据
    if(Serial2.available())
    {
         Serial.write(Serial2.read()); 
  
    }


  
}
