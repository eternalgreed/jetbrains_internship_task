import java.util.*;


public class LoaderOptimizer {
    int maximizeEarning(List<Train> trains) {
        Integer[] lineSegmentEndPointCoords = new Integer[2 * trains.size()];
        for (int i = 0; i < trains.size(); i++) {
            lineSegmentEndPointCoords[2 * i] = trains.get(i).getTimeArrive();
            lineSegmentEndPointCoords[2 * i + 1] = trains.get(i).getUnloadEnd();
        }
        Arrays.sort(lineSegmentEndPointCoords);
        Integer[] endPointsWithoutDuplicates = removeDuplicateCoords(lineSegmentEndPointCoords);
        Map<Integer, Integer> compressedCoords = compressCoords(endPointsWithoutDuplicates);
        List<List<Integer>> bunchWithRightEndpointAtIPos = new ArrayList<>();
        for (int i = 0; i < compressedCoords.size(); i++) {
            bunchWithRightEndpointAtIPos.add(new ArrayList<>());
        }
        for (int i = 0; i < trains.size(); i++) {
            bunchWithRightEndpointAtIPos.get(compressedCoords.get(trains.get(i).getUnloadEnd())).add(i);
        }

        int[] answer = new int[compressedCoords.size()];
        for (int i = 1; i < compressedCoords.size(); i++) {
            if (!bunchWithRightEndpointAtIPos.get(i).isEmpty()) {
                int maxEartingAtRightEndPoint = 0;
                for (int k = 0; k < bunchWithRightEndpointAtIPos.get(i).size(); k++) {
                    if (maxEartingAtRightEndPoint < (answer[compressedCoords.get(trains.get(bunchWithRightEndpointAtIPos.get(i).get(k)).getTimeArrive())] + trains.get(bunchWithRightEndpointAtIPos.get(i).get(k)).getSalary())) {
                        maxEartingAtRightEndPoint = (answer[compressedCoords.get(trains.get(bunchWithRightEndpointAtIPos.get(i).get(k)).getTimeArrive())] + trains.get(bunchWithRightEndpointAtIPos.get(i).get(k)).getSalary());
                    }
                }
                answer[i] = Math.max(answer[i - 1], maxEartingAtRightEndPoint);
            } else {
                answer[i] = answer[i - 1];
            }
        }
        return answer[compressedCoords.size() - 1];
    }

    Integer[] removeDuplicateCoords(Integer[] lineSegmentEndPointCoords) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(lineSegmentEndPointCoords));
        Integer[] coordsWithoutDuplicates = linkedHashSet.toArray(new Integer[]{});
        return coordsWithoutDuplicates;
    }

    Map<Integer, Integer> compressCoords(Integer[] endPointsWithoutDuplicates) {
        Map<Integer, Integer> compressedCoords = new HashMap<>();
        for (int i = 0; i < endPointsWithoutDuplicates.length; i++) {
            compressedCoords.put(endPointsWithoutDuplicates[i], i);
        }
        return compressedCoords;
    }

}

