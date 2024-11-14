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

package org.apache.celeborn.common.network.protocol;

import java.util.Arrays;

import com.google.common.base.Objects;
import io.netty.buffer.ByteBuf;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PushMergedDataUnsuccessfulPartitionInfo extends ResponseMessage {
  public final int[] unsuccessfulPartitionIndexes;
  public final byte[] statusCodes;

  public PushMergedDataUnsuccessfulPartitionInfo(
      int[] unsuccessfulPartitionIndexes, byte[] statusCodes) {
    this.unsuccessfulPartitionIndexes = unsuccessfulPartitionIndexes;
    this.statusCodes = statusCodes;
  }

  @Override
  public Type type() {
    return Type.PUSH_MERGED_DATA_UNSUCCESSFUL_PARTITION_INFO;
  }

  @Override
  public int encodedLength() {
    return Encoders.IntArrays.encodedLength(unsuccessfulPartitionIndexes)
        + Encoders.ByteArrays.encodedLength(statusCodes);
  }

  @Override
  public void encode(ByteBuf buf) {
    Encoders.IntArrays.encode(buf, unsuccessfulPartitionIndexes);
    Encoders.ByteArrays.encode(buf, statusCodes);
  }

  public static PushMergedDataUnsuccessfulPartitionInfo decode(ByteBuf buf) {
    int[] unsuccessfulPartitionIndexes = Encoders.IntArrays.decode(buf);
    byte[] statusCodes = Encoders.ByteArrays.decode(buf);
    return new PushMergedDataUnsuccessfulPartitionInfo(unsuccessfulPartitionIndexes, statusCodes);
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof PushMergedDataUnsuccessfulPartitionInfo) {
      PushMergedDataUnsuccessfulPartitionInfo o = (PushMergedDataUnsuccessfulPartitionInfo) other;
      return Arrays.equals(unsuccessfulPartitionIndexes, o.unsuccessfulPartitionIndexes)
          && Arrays.equals(statusCodes, o.statusCodes)
          && super.equals(o);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        Arrays.hashCode(unsuccessfulPartitionIndexes), Arrays.hashCode(statusCodes));
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("unsuccessfulPartitionIndexes", unsuccessfulPartitionIndexes)
        .append("statusCodes", statusCodes)
        .toString();
  }
}
