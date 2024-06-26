package SYnthesizer;

import javax.sound.midi.*;
import java.util.List;

public class TestSynth {
    Synthesizer synthesizer = new Synthesizer() {
        @Override
        public int getMaxPolyphony() {
            return 0;
        }

        @Override
        public long getLatency() {
            return 0;
        }

        @Override
        public MidiChannel[] getChannels() {
            return new MidiChannel[0];
        }

        @Override
        public VoiceStatus[] getVoiceStatus() {
            return new VoiceStatus[0];
        }

        @Override
        public boolean isSoundbankSupported(Soundbank soundbank) {
            return false;
        }

        @Override
        public boolean loadInstrument(Instrument instrument) {
            return false;
        }

        @Override
        public void unloadInstrument(Instrument instrument) {

        }

        @Override
        public boolean remapInstrument(Instrument from, Instrument to) {
            return false;
        }

        @Override
        public Soundbank getDefaultSoundbank() {
            return null;
        }

        @Override
        public Instrument[] getAvailableInstruments() {
            return new Instrument[0];
        }

        @Override
        public Instrument[] getLoadedInstruments() {
            return new Instrument[0];
        }

        @Override
        public boolean loadAllInstruments(Soundbank soundbank) {
            return false;
        }

        @Override
        public void unloadAllInstruments(Soundbank soundbank) {

        }

        @Override
        public boolean loadInstruments(Soundbank soundbank, Patch[] patchList) {
            return false;
        }

        @Override
        public void unloadInstruments(Soundbank soundbank, Patch[] patchList) {

        }

        @Override
        public Info getDeviceInfo() {
            return null;
        }

        @Override
        public void open() throws MidiUnavailableException {

        }

        @Override
        public void close() {

        }

        @Override
        public boolean isOpen() {
            return false;
        }

        @Override
        public long getMicrosecondPosition() {
            return 0;
        }

        @Override
        public int getMaxReceivers() {
            return 0;
        }

        @Override
        public int getMaxTransmitters() {
            return 0;
        }

        @Override
        public Receiver getReceiver() throws MidiUnavailableException {
            return null;
        }

        @Override
        public List<Receiver> getReceivers() {
            return List.of();
        }

        @Override
        public Transmitter getTransmitter() throws MidiUnavailableException {
            return null;
        }

        @Override
        public List<Transmitter> getTransmitters() {
            return List.of();
        }
    };
    public static void main(String[] args) {

    }
}
