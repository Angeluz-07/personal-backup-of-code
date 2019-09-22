/*
 * The MIT License
 *
 * Copyright 2017 User.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author User
 */
public class Ruta {
        private String Aerolinea;
        private String AerolineaID;
        private Aeropuerto AeropuertoPartida,AeropuertoDestino;
        private String AeropuertoPartidaID,AeropuertoDestinoID;
        private String CodigoCompartido;
        private String Paradas;
        private String  Flota;

    public Ruta(String Aerolinea, String AerolineaID, Aeropuerto AeropuertoPartida, Aeropuerto AeropuertoDestino, String AeropuertoPartidaID, String AeropuertoDestinoID, String CodigoCompartido, String Paradas, String Flota) {
        this.Aerolinea = Aerolinea;
        this.AerolineaID = AerolineaID;
        this.AeropuertoPartida = AeropuertoPartida;
        this.AeropuertoDestino = AeropuertoDestino;
        this.AeropuertoPartidaID = AeropuertoPartidaID;
        this.AeropuertoDestinoID = AeropuertoDestinoID;
        this.CodigoCompartido = CodigoCompartido;
        this.Paradas = Paradas;
        this.Flota = Flota;
    }

    public String getAerolinea() {
        return Aerolinea;
    }

    public void setAerolinea(String Aerolinea) {
        this.Aerolinea = Aerolinea;
    }

    public String getAerolineaID() {
        return AerolineaID;
    }

    public void setAerolineaID(String AerolineaID) {
        this.AerolineaID = AerolineaID;
    }

    public Aeropuerto getAeropuertoPartida() {
        return AeropuertoPartida;
    }

    public void setAeropuertoPartida(Aeropuerto AeropuertoPartida) {
        this.AeropuertoPartida = AeropuertoPartida;
    }

    public Aeropuerto getAeropuertoDestino() {
        return AeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto AeropuertoDestino) {
        this.AeropuertoDestino = AeropuertoDestino;
    }

    public String getAeropuertoPartidaID() {
        return AeropuertoPartidaID;
    }

    public void setAeropuertoPartidaID(String AeropuertoPartidaID) {
        this.AeropuertoPartidaID = AeropuertoPartidaID;
    }

    public String getAeropuertoDestinoID() {
        return AeropuertoDestinoID;
    }

    public void setAeropuertoDestinoID(String AeropuertoDestinoID) {
        this.AeropuertoDestinoID = AeropuertoDestinoID;
    }

    public String getCodigoCompartido() {
        return CodigoCompartido;
    }

    public void setCodigoCompartido(String CodigoCompartido) {
        this.CodigoCompartido = CodigoCompartido;
    }

    public String getParadas() {
        return Paradas;
    }

    public void setParadas(String Paradas) {
        this.Paradas = Paradas;
    }

    public String getFlota() {
        return Flota;
    }

    public void setFlota(String Flota) {
        this.Flota = Flota;
    }

    @Override
    public String toString() {
        return "Ruta{" +"APPartidaID=" + AeropuertoPartidaID + ",APDestinoID=" + AeropuertoDestinoID + ",APPartida=" + AeropuertoPartida + ",APDestino=" + AeropuertoDestino +",Aerolinea="+ Aerolinea+"}";
    }
        
}
