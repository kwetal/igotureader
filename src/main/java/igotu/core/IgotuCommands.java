package igotu.core;

/**
 * Created by in568bax on 2017-06-26.
 */
public interface IgotuCommands {
    NmeaSwitchCommandResponse NmeaSwitchCommand(GpsMode mode);
    IdentificationCommandResponse IdentificationCommand();
    CountCommandResponse CountCommand();
    InternalMemoryRead1Response InternalMemoryRead1(int size, int position);
    ModelCommandResponse ModelCommand();
    InternalMemoryRead2Response InternalMemoryRead2(int size);
    ReadCommandResponse ReadCommand(int size, int position);

    /**
     *
     * @param mode 00 for purge, 01? for write
     * @return
     */
    UnknownWriteCommand1Response UnknownWriteCommand1(int mode);
    WriteCommandResponse WriteCommand(int mode, int size, int position, byte[] data);
    UnknownWriteCommand2Response UnknownWriteCommand2(int size);

    /**
     *
     * @param mode first time called 1E, second time called 1F
     * @return
     */
    UnknownPurgeCommand1Response UnknownPurgeCommand1(int mode);
    UnknownPurgeCommand2Response UnknownPurgeCommand2();
    BC4OffModeCommandResponse BC4OffModeCommand(int xx, int hh, int mm, int ll);
}
