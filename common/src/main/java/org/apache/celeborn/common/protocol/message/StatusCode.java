/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.celeborn.common.protocol.message;

public enum StatusCode {
  // 1/0 Status
  SUCCESS(0),
  PARTIAL_SUCCESS(1),
  REQUEST_FAILED(2),

  // Specific Status
  SHUFFLE_ALREADY_REGISTERED(3),
  SHUFFLE_NOT_REGISTERED(4),
  RESERVE_SLOTS_FAILED(5),
  SLOT_NOT_AVAILABLE(6),
  WORKER_NOT_FOUND(7),
  PARTITION_NOT_FOUND(8),
  REPLICA_PARTITION_NOT_FOUND(9),
  DELETE_FILES_FAILED(10),
  PARTITION_EXISTS(11),
  REVIVE_FAILED(12),
  REPLICATE_DATA_FAILED(13),
  NUM_MAPPER_ZERO(14),
  MAP_ENDED(15),
  STAGE_ENDED(16),

  // push data fail causes
  PUSH_DATA_FAIL_NON_CRITICAL_CAUSE_PRIMARY(17),
  PUSH_DATA_WRITE_FAIL_REPLICA(18),
  PUSH_DATA_WRITE_FAIL_PRIMARY(19),
  PUSH_DATA_FAIL_PARTITION_NOT_FOUND(20),

  HARD_SPLIT(21),
  SOFT_SPLIT(22),

  STAGE_END_TIME_OUT(23),
  SHUFFLE_DATA_LOST(24),
  WORKER_SHUTDOWN(25),
  NO_AVAILABLE_WORKING_DIR(26),
  WORKER_EXCLUDED(27),
  WORKER_UNKNOWN(28),

  COMMIT_FILE_EXCEPTION(29),

  // Rate limit statuses
  PUSH_DATA_SUCCESS_PRIMARY_CONGESTED(30),
  PUSH_DATA_SUCCESS_REPLICA_CONGESTED(31),

  PUSH_DATA_HANDSHAKE_FAIL_REPLICA(32),
  PUSH_DATA_HANDSHAKE_FAIL_PRIMARY(33),
  REGION_START_FAIL_REPLICA(34),
  REGION_START_FAIL_PRIMARY(35),
  REGION_FINISH_FAIL_REPLICA(36),
  REGION_FINISH_FAIL_PRIMARY(37),

  PUSH_DATA_CREATE_CONNECTION_FAIL_PRIMARY(38),
  PUSH_DATA_CREATE_CONNECTION_FAIL_REPLICA(39),
  PUSH_DATA_CONNECTION_EXCEPTION_PRIMARY(40),
  PUSH_DATA_CONNECTION_EXCEPTION_REPLICA(41),
  PUSH_DATA_TIMEOUT_PRIMARY(42),
  PUSH_DATA_TIMEOUT_REPLICA(43),
  PUSH_DATA_PRIMARY_WORKER_EXCLUDED(44),
  PUSH_DATA_REPLICA_WORKER_EXCLUDED(45),

  FETCH_DATA_TIMEOUT(46),
  REVIVE_INITIALIZED(47),
  DESTROY_SLOTS_MOCK_FAILURE(48),
  COMMIT_FILES_MOCK_FAILURE(49),
  PUSH_DATA_FAIL_NON_CRITICAL_CAUSE_REPLICA(50),
  OPEN_STREAM_FAILED(51),
  SEGMENT_START_FAIL_REPLICA(52),
  SEGMENT_START_FAIL_PRIMARY(53);

  private final byte value;

  StatusCode(int value) {
    assert (value >= 0 && value < 256);
    this.value = (byte) value;
  }

  public final byte getValue() {
    return value;
  }

  public static StatusCode fromValue(byte value) {
    switch (value) {
      case 0:
        return SUCCESS;
      case 1:
        return PARTIAL_SUCCESS;
      case 2:
        return REQUEST_FAILED;
      case 3:
        return SHUFFLE_ALREADY_REGISTERED;
      case 4:
        return SHUFFLE_NOT_REGISTERED;
      case 5:
        return RESERVE_SLOTS_FAILED;
      case 6:
        return SLOT_NOT_AVAILABLE;
      case 7:
        return WORKER_NOT_FOUND;
      case 8:
        return PARTITION_NOT_FOUND;
      case 9:
        return REPLICA_PARTITION_NOT_FOUND;
      case 10:
        return DELETE_FILES_FAILED;
      case 11:
        return PARTITION_EXISTS;
      case 12:
        return REVIVE_FAILED;
      case 13:
        return REPLICATE_DATA_FAILED;
      case 14:
        return NUM_MAPPER_ZERO;
      case 15:
        return MAP_ENDED;
      case 16:
        return STAGE_ENDED;
      case 17:
        return PUSH_DATA_FAIL_NON_CRITICAL_CAUSE_PRIMARY;
      case 18:
        return PUSH_DATA_WRITE_FAIL_REPLICA;
      case 19:
        return PUSH_DATA_WRITE_FAIL_PRIMARY;
      case 20:
        return PUSH_DATA_FAIL_PARTITION_NOT_FOUND;
      case 21:
        return HARD_SPLIT;
      case 22:
        return SOFT_SPLIT;
      case 23:
        return STAGE_END_TIME_OUT;
      case 24:
        return SHUFFLE_DATA_LOST;
      case 25:
        return WORKER_SHUTDOWN;
      case 26:
        return NO_AVAILABLE_WORKING_DIR;
      case 27:
        return WORKER_EXCLUDED;
      case 28:
        return WORKER_UNKNOWN;
      case 29:
        return COMMIT_FILE_EXCEPTION;
      case 30:
        return PUSH_DATA_SUCCESS_PRIMARY_CONGESTED;
      case 31:
        return PUSH_DATA_SUCCESS_REPLICA_CONGESTED;
      case 32:
        return PUSH_DATA_HANDSHAKE_FAIL_REPLICA;
      case 33:
        return PUSH_DATA_HANDSHAKE_FAIL_PRIMARY;
      case 34:
        return REGION_START_FAIL_REPLICA;
      case 35:
        return REGION_START_FAIL_PRIMARY;
      case 36:
        return REGION_FINISH_FAIL_REPLICA;
      case 37:
        return REGION_FINISH_FAIL_PRIMARY;
      case 38:
        return PUSH_DATA_CREATE_CONNECTION_FAIL_PRIMARY;
      case 39:
        return PUSH_DATA_CREATE_CONNECTION_FAIL_REPLICA;
      case 40:
        return PUSH_DATA_CONNECTION_EXCEPTION_PRIMARY;
      case 41:
        return PUSH_DATA_CONNECTION_EXCEPTION_REPLICA;
      case 42:
        return PUSH_DATA_TIMEOUT_PRIMARY;
      case 43:
        return PUSH_DATA_TIMEOUT_REPLICA;
      case 44:
        return PUSH_DATA_PRIMARY_WORKER_EXCLUDED;
      case 45:
        return PUSH_DATA_REPLICA_WORKER_EXCLUDED;
      case 46:
        return FETCH_DATA_TIMEOUT;
      case 47:
        return REVIVE_INITIALIZED;
      case 48:
        return DESTROY_SLOTS_MOCK_FAILURE;
      case 49:
        return COMMIT_FILES_MOCK_FAILURE;
      case 50:
        return PUSH_DATA_FAIL_NON_CRITICAL_CAUSE_REPLICA;
      case 51:
        return OPEN_STREAM_FAILED;
      case 52:
        return SEGMENT_START_FAIL_REPLICA;
      case 53:
        return SEGMENT_START_FAIL_PRIMARY;
      default:
        throw new IllegalArgumentException("Unknown status code: " + value);
    }
  }
}
