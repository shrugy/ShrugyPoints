package git.mmdhashemian.shrugypoints.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * ShrugyPoint object
 */
@Getter
@RequiredArgsConstructor
public class ShrugyPoint {
    private final UUID player;
    private final double points;
    private final List<History> pointsHistory;

    @Getter
    @RequiredArgsConstructor
    public static class History {
        private final double points;
        private final long timeStamp;
        private final UUID transferId;
    }
}